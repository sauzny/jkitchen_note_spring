package com.sauzny.sbjpademo.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sauzny.sbjpademo.entity.Student;
import com.sauzny.sbjpademo.entity.Teacher;
import com.sauzny.sbjpademo.jpa.TeacherRepository;

@Service
public class TeacherService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private TeacherRepository teacherRepository;

	public List<Teacher> addTeacher(List<Teacher> entities) {
		return teacherRepository.saveAll(entities);
	}

	public Teacher addTeacher(Teacher entity) {
		return teacherRepository.saveAndFlush(entity);
	}

	public Teacher findWithTeachersById(Long id) {
		return teacherRepository.findWithStudentsById(id);
	}

	public Teacher findByIdAndFetchStudentsEagerly(Long id) {
		return teacherRepository.findByIdAndFetchStudentsEagerly(id);
	}

	public List<Teacher> findAll(List<String> names) {
		return teacherRepository.findAll(TeacherWhereBuilder.queryWithNames(names));
	}

	public Page<Teacher> findAll(Pageable pageable) {
		return teacherRepository.findAll(pageable);
	}

	public Page<Teacher> findAll(String name, Integer number, Integer size) {
		return teacherRepository.findAll(
				TeacherWhereBuilder.query(name),
				PageRequest.of(number, size, new Sort(Sort.Direction.DESC, "createTime"))
				);
	}

	public Page<Teacher> findAll(List<String> studentNames, Integer number, Integer size) {
		return teacherRepository.findAll(
				TeacherWhereBuilder.query(studentNames),
				PageRequest.of(number, size, new Sort(Sort.Direction.DESC, "createTime"))
				);
	}

	// JPA update
	public Teacher jpaUpdate(Teacher setEntity, Teacher whereEntity) {

		// 1 先查询，查询的时候可以使用灵活的where条件查询
		Teacher target = teacherRepository.findById(whereEntity.getId()).get();
		target.setName(setEntity.getName());

		// 2 再修改
		// ps 有个注解 @DynamicUpdate，使用在 entity 上，这样生成的sql中，只会set不是null的字段
		return teacherRepository.saveAndFlush(target);
	}

	// 上下两种update有什么区别呢？ 自己了解一下jpa的一级缓存

	// entityManager update
	/**
	 * update 语句 其实是两个 entity setEntity是set时候使用，是动态的 whereEntity是where时候使用，是动态的
	 */
	@Transactional
	public int entityManagerUpdate(Teacher setEntity, Teacher whereEntity) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Teacher> update = criteriaBuilder.createCriteriaUpdate(Teacher.class);
		Root<Teacher> root = update.from(Teacher.class);

		Predicate predicate = TeacherWhereBuilder.updateWithDynamicEqual(root, criteriaBuilder, whereEntity);

		// 此处的set是动态的，也可以按照实际情况编写
		// reflectasm 这是 一个反射框架，这个地方也可以写反射，但是要缓存起来，别每次都创建新的反射工具对象。
		Map<String, Object> setColumnMap = Maps.newHashMap();
		if (setEntity.getName() != null)
			setColumnMap.put("name", setEntity.getName());

		// 设置set
		setColumnMap.forEach((attributeName, value) -> update.set(attributeName, value));

		// 设置where
		update.where(predicate);

		return entityManager.createQuery(update).executeUpdate();
	}

}

// where部分构造器
// 我的想法是编写一个 全部字段都是equal的方法，按照字段是否为null来确认是否需要equal，作为基础通用where。
// reflectasm 这是 一个反射框架，这个地方也可以写反射，但是要缓存起来，别每次都创建新的反射工具对象。
// where是都需要一个通用方法，看实际业务需求吧
class TeacherWhereBuilder {

	public static Predicate updateWithDynamicEqual(Root<Teacher> root, CriteriaBuilder criteriaBuilder,
			Teacher whereEntity) {

		List<Predicate> predicates = Lists.newLinkedList();

		// id 作为查询条件
		if (whereEntity.getId() != null) {
			predicates.add(criteriaBuilder.equal(root.get("id"), whereEntity.getId()));
		}

		// universityId 作为查询条件
		if (whereEntity.getUniversityId() != null) {
			predicates.add(criteriaBuilder.equal(root.get("universityId"), whereEntity.getUniversityId()));
		}

		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	public static Specification<Teacher> queryWithNames(List<String> names) {

		return ((root, query, criteriaBuilder) -> {

			List<Predicate> predicates = Lists.newLinkedList();

			if (names != null && names.size() > 0) {
				CriteriaBuilder.In<String> in = criteriaBuilder.in(root.get("name"));
				names.forEach(name -> in.value(name));
				predicates.add(in);
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
	}

	public static Specification<Teacher> query(String name) {

		return ((root, query, criteriaBuilder) -> {

			List<Predicate> predicates = Lists.newLinkedList();

			if (name != null) {
				predicates.add(criteriaBuilder.equal(root.get("name"), name));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
	}
	
	public static Specification<Teacher> query(List<String> studentNames) {

		return ((root, query, criteriaBuilder) -> {

			List<Predicate> predicates = Lists.newLinkedList();

			if (!CollectionUtils.isEmpty(studentNames)) {
				Join<Student, Teacher> student = root.join("students", JoinType.INNER);
				CriteriaBuilder.In<String> in = criteriaBuilder.in(student.get("name"));
				studentNames.forEach(name -> in.value(name));
				predicates.add(in);
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
	}
}
