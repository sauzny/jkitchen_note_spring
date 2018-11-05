package com.sauzny.sbjpademo;

import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.sauzny.sbjpademo.entity.Student;
import com.sauzny.sbjpademo.entity.Teacher;
import com.sauzny.sbjpademo.entity.University;
import com.sauzny.sbjpademo.service.StudentService;
import com.sauzny.sbjpademo.service.TeacherService;
import com.sauzny.sbjpademo.service.UniversityService;
import com.sauzny.sbjpademo.utils.JacksonUtils;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {

	@Autowired
	public StudentService studentService;

	@Autowired
	public TeacherService teacherService;

	@Autowired
	public UniversityService universityService;
	
	// faker
	static Faker faker = new Faker(new Locale("zh","CN")) ;

	@Test
	public void addUniversities() {

		List<University> universities = Lists.newArrayList();
		for(int i=0; i<20; i++) {
			University university = new University();
			university.setName(faker.university().name());
			universities.add(university);
		}
		universityService.addUniversity(universities);
	}
	
	@Test
	public void addTeachers() {
		
		List<Teacher> teachers = Lists.newArrayList();
		for(int i=0; i<100; i++) {
			Teacher teacher = new Teacher();
			teacher.setName(faker.name().name());
			teacher.setUniversityId(faker.number().numberBetween(1L, 20L));
			teachers.add(teacher);
		}
		teacherService.addTeacher(teachers);
	}
	
	@Test
	public void addStudents() {

		List<Student> students = Lists.newArrayList();
		for(int i=0; i<200; i++) {
			Student student = new Student();
			student.setName(faker.name().name());
			student.setTeacherId(faker.number().numberBetween(30L, 60L));
			students.add(student);
		}
		studentService.addStudent(students);
	}
	
	@Test
	public void updateTeacher() {
		Teacher whereEntity = new Teacher();
		whereEntity.setId(5L);
		whereEntity.setUniversityId(16L);
		Teacher setEntity = new Teacher();
		setEntity.setName("修改成功");
		teacherService.entityManagerUpdate(setEntity, whereEntity);
	}

	// N+1问题 三层结构的查询  学校 == 老师 == 学生
	@Test
	public void queryUniversityById() {
		University university = universityService.findWithTeachersById(9L);
		log.info("university.getTeachers().size() = {}", university.getTeachers().size());
		log.info("university = {}", JacksonUtils.nonNull().toJson(university));
	}

	// N+1问题  两种方式
	// ========================================
	@Test
	public void queryTeacherUseEntityGraph() {
		Teacher teacher = teacherService.findWithTeachersById(49L);
		log.info("teacher = {}", teacher);
	}
	
	@Test
	public void queryTeacherUseQuery() {
		Teacher teacher = teacherService.findByIdAndFetchStudentsEagerly(49L);
		log.info("teacher = {}", teacher);
	}
	// ========================================
	
	// 不加载teacher中的students
	@Test
	public void queryTeachersWithNames() {
		
		List<String> names = Lists.newArrayList("卢煜祺", "卢鸿涛", "余伟祺");
		List<Teacher> teachers = teacherService.findAll(names);
		
		teachers.forEach(teacher -> log.info("teacher.id = {}", teacher.getId()) );
	}
	
	// 多表动态查询，分页 页码从0开始
	@Test
	public void queryTeachersWithStudentNames() {

		List<String> names = Lists.newArrayList("周博文", "周瑞霖", "李金鑫");
		Page<Teacher> teachers = teacherService.findAll(names, 0, 10);

		teachers.getContent().forEach(teacher -> log.info("teacher.id = {}", teacher.getId()));
	}
}
