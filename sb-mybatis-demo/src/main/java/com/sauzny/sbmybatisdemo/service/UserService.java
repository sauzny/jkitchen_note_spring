package com.sauzny.sbmybatisdemo.service;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.sauzny.sbmybatisdemo.dao.UserDao;
import com.sauzny.sbmybatisdemo.dao.mapper.UserMapper;
import com.sauzny.sbmybatisdemo.entity.bo.FatUser;
import com.sauzny.sbmybatisdemo.entity.po.User;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.render.TableAliasCalculator;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.where.render.WhereClauseProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

import static com.sauzny.sbmybatisdemo.dao.mapper.UserDynamicSqlSupport.*;
import static com.sauzny.sbmybatisdemo.dao.mapper.CompanyDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
@Slf4j
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void selectTest() {
        long totalRows = userDao.count(c -> c);
        //long totalRows = userDao.count(CountDSLCompleter.allRows());
        List<User> allRecords = userDao.select(c -> c);
        //List<TableCode> allRecords = userDao.select(SelectDSLCompleter.allRows());

        List<User> records1 = userDao.select(c -> c.where(userId, isEqualTo(3)));

        List<User> records2 = userDao.select(c ->
                c.where(userId, isEqualTo(3)).or(userName, isLike("%曹%")));

        List<User> records3 = userDao.select(c ->
                c.where(userId, isLessThan(10), and(userName, isEqualTo("foo")))
                        .or(userName, isLike("b%"))
                        .orderBy(userId.descending()));


        List<User> records4 = userDao.select(c -> {
            var builder = c.where();
            //if(something) builder.and(userId, isEqualTo(3));
            // mybatis不保证sql可用，只是拼接到sql中
            // 用户自行判断 sql 是否可用  limit offset fetch
            builder.limit(10);
            builder.offset(30);
            //builder.fetchFirst(10).rowsOnly();
            builder.orderBy(userId.descending());
            return c;
        });

        log.info("totalRows : {}", totalRows);
        log.info("records1 : {}", records1);
        log.info("records2 : {}", records2);
        log.info("records3 : {}", records3);
        log.info("records4 : {}", records4);

        // 开始测试 自定义 SelectStatementProvider
        SelectStatementProvider selectStatement = select(count())
                .from(user, "a")
                .where(userId, isGreaterThan(100))
                .or(userPhoneNum, isNotNull(), and(userId, isLessThan(200)))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        long records5 = userDao.count(selectStatement);

        // 开始测试 自定义sql
        WhereClauseProvider whereClause = where(userId, isNotBetween(10).and(60))
                .build()
                //如果sql中没有使用表别名
                // .render(RenderingStrategies.MYBATIS3);
                // 如果sql中使用了表别名
                .render(RenderingStrategies.MYBATIS3, TableAliasCalculator.of(user, "a"));
        List<User> records6 = userDao.selectByExample(whereClause);

        // 开始测试自定义返回结果
        List<FatUser> records7 = userDao.selectFatUserMany(
                select(user.userId, user.userName, company.companyId, company.companyName)
                        .from(user)
                        .join(company).on(user.companyId, equalTo(company.companyId))
                        .where(user.userPhoneNum, isNotNull())
                        .build()
                        .render(RenderingStrategies.MYBATIS3));

        log.info("records5 : {}", records5);
        log.info("records6 : {}", records6);
        log.info("records7 : {}", records7);
    }

    public void writeTest() {


        Locale local = new Locale("zh", "CN");
        //创建对象
        Faker faker = new Faker(local);


        // 插入一条
        User one = new User();
        one.setUserName(faker.name().fullName());
        one.setUserEmail(faker.internet().emailAddress());
        one.setCompanyId(1);
        userDao.insert(one);

        // 插入多条
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 16; i++) {
            User user = new User();
            user.setUserName(faker.name().fullName());
            user.setUserEmail(faker.internet().emailAddress());
            user.setCompanyId(1);
            list.add(user);
        }
        userDao.insertMultiple(list);

        // 删除 userName == null 的记录
        userDao.delete(c -> c.where(userName, isEqualTo("foo")));
        userDao.delete(c -> c.where(userName, isNull()));

        // 将userid是 100 的用户 手机号 修改
        int rows1 = userDao.update(c ->
                c.set(userPhoneNum).equalTo(faker.phoneNumber().cellPhone())
                        .where(userId, isEqualTo(100)));

        User record = new User();
        record.setUserPhoneNum(faker.phoneNumber().cellPhone());

        // 将userid是 101 的用户 只设置手机号
        int rows2 = userDao.update(c ->
                UserMapper.updateAllColumns(record, c)
                        .where(userId, isEqualTo(101))
                        .or(userName, isLike("f%")));

        // 将userid是 102 的用户 手机号 修改
        int rows3 = userDao.update(c ->
                UserMapper.updateSelectiveColumns(record, c)
                        .where(userId, isEqualTo(102))
                        .or(userName, isLike("f%")));
    }

}
