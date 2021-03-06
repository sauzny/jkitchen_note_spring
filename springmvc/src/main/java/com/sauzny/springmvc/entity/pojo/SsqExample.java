package com.sauzny.springmvc.entity.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SsqExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public SsqExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQihaoIsNull() {
            addCriterion("qihao is null");
            return (Criteria) this;
        }

        public Criteria andQihaoIsNotNull() {
            addCriterion("qihao is not null");
            return (Criteria) this;
        }

        public Criteria andQihaoEqualTo(Integer value) {
            addCriterion("qihao =", value, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoNotEqualTo(Integer value) {
            addCriterion("qihao <>", value, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoGreaterThan(Integer value) {
            addCriterion("qihao >", value, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoGreaterThanOrEqualTo(Integer value) {
            addCriterion("qihao >=", value, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoLessThan(Integer value) {
            addCriterion("qihao <", value, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoLessThanOrEqualTo(Integer value) {
            addCriterion("qihao <=", value, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoIn(List<Integer> values) {
            addCriterion("qihao in", values, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoNotIn(List<Integer> values) {
            addCriterion("qihao not in", values, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoBetween(Integer value1, Integer value2) {
            addCriterion("qihao between", value1, value2, "qihao");
            return (Criteria) this;
        }

        public Criteria andQihaoNotBetween(Integer value1, Integer value2) {
            addCriterion("qihao not between", value1, value2, "qihao");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNull() {
            addCriterion("riqi is null");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNotNull() {
            addCriterion("riqi is not null");
            return (Criteria) this;
        }

        public Criteria andRiqiEqualTo(Date value) {
            addCriterionForJDBCDate("riqi =", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotEqualTo(Date value) {
            addCriterionForJDBCDate("riqi <>", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThan(Date value) {
            addCriterionForJDBCDate("riqi >", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("riqi >=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThan(Date value) {
            addCriterionForJDBCDate("riqi <", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("riqi <=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiIn(List<Date> values) {
            addCriterionForJDBCDate("riqi in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotIn(List<Date> values) {
            addCriterionForJDBCDate("riqi not in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("riqi between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("riqi not between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andShunxu1IsNull() {
            addCriterion("shunxu1 is null");
            return (Criteria) this;
        }

        public Criteria andShunxu1IsNotNull() {
            addCriterion("shunxu1 is not null");
            return (Criteria) this;
        }

        public Criteria andShunxu1EqualTo(Integer value) {
            addCriterion("shunxu1 =", value, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1NotEqualTo(Integer value) {
            addCriterion("shunxu1 <>", value, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1GreaterThan(Integer value) {
            addCriterion("shunxu1 >", value, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1GreaterThanOrEqualTo(Integer value) {
            addCriterion("shunxu1 >=", value, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1LessThan(Integer value) {
            addCriterion("shunxu1 <", value, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1LessThanOrEqualTo(Integer value) {
            addCriterion("shunxu1 <=", value, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1In(List<Integer> values) {
            addCriterion("shunxu1 in", values, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1NotIn(List<Integer> values) {
            addCriterion("shunxu1 not in", values, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1Between(Integer value1, Integer value2) {
            addCriterion("shunxu1 between", value1, value2, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu1NotBetween(Integer value1, Integer value2) {
            addCriterion("shunxu1 not between", value1, value2, "shunxu1");
            return (Criteria) this;
        }

        public Criteria andShunxu2IsNull() {
            addCriterion("shunxu2 is null");
            return (Criteria) this;
        }

        public Criteria andShunxu2IsNotNull() {
            addCriterion("shunxu2 is not null");
            return (Criteria) this;
        }

        public Criteria andShunxu2EqualTo(Integer value) {
            addCriterion("shunxu2 =", value, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2NotEqualTo(Integer value) {
            addCriterion("shunxu2 <>", value, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2GreaterThan(Integer value) {
            addCriterion("shunxu2 >", value, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2GreaterThanOrEqualTo(Integer value) {
            addCriterion("shunxu2 >=", value, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2LessThan(Integer value) {
            addCriterion("shunxu2 <", value, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2LessThanOrEqualTo(Integer value) {
            addCriterion("shunxu2 <=", value, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2In(List<Integer> values) {
            addCriterion("shunxu2 in", values, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2NotIn(List<Integer> values) {
            addCriterion("shunxu2 not in", values, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2Between(Integer value1, Integer value2) {
            addCriterion("shunxu2 between", value1, value2, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu2NotBetween(Integer value1, Integer value2) {
            addCriterion("shunxu2 not between", value1, value2, "shunxu2");
            return (Criteria) this;
        }

        public Criteria andShunxu3IsNull() {
            addCriterion("shunxu3 is null");
            return (Criteria) this;
        }

        public Criteria andShunxu3IsNotNull() {
            addCriterion("shunxu3 is not null");
            return (Criteria) this;
        }

        public Criteria andShunxu3EqualTo(Integer value) {
            addCriterion("shunxu3 =", value, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3NotEqualTo(Integer value) {
            addCriterion("shunxu3 <>", value, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3GreaterThan(Integer value) {
            addCriterion("shunxu3 >", value, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3GreaterThanOrEqualTo(Integer value) {
            addCriterion("shunxu3 >=", value, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3LessThan(Integer value) {
            addCriterion("shunxu3 <", value, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3LessThanOrEqualTo(Integer value) {
            addCriterion("shunxu3 <=", value, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3In(List<Integer> values) {
            addCriterion("shunxu3 in", values, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3NotIn(List<Integer> values) {
            addCriterion("shunxu3 not in", values, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3Between(Integer value1, Integer value2) {
            addCriterion("shunxu3 between", value1, value2, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu3NotBetween(Integer value1, Integer value2) {
            addCriterion("shunxu3 not between", value1, value2, "shunxu3");
            return (Criteria) this;
        }

        public Criteria andShunxu4IsNull() {
            addCriterion("shunxu4 is null");
            return (Criteria) this;
        }

        public Criteria andShunxu4IsNotNull() {
            addCriterion("shunxu4 is not null");
            return (Criteria) this;
        }

        public Criteria andShunxu4EqualTo(Integer value) {
            addCriterion("shunxu4 =", value, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4NotEqualTo(Integer value) {
            addCriterion("shunxu4 <>", value, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4GreaterThan(Integer value) {
            addCriterion("shunxu4 >", value, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4GreaterThanOrEqualTo(Integer value) {
            addCriterion("shunxu4 >=", value, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4LessThan(Integer value) {
            addCriterion("shunxu4 <", value, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4LessThanOrEqualTo(Integer value) {
            addCriterion("shunxu4 <=", value, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4In(List<Integer> values) {
            addCriterion("shunxu4 in", values, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4NotIn(List<Integer> values) {
            addCriterion("shunxu4 not in", values, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4Between(Integer value1, Integer value2) {
            addCriterion("shunxu4 between", value1, value2, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu4NotBetween(Integer value1, Integer value2) {
            addCriterion("shunxu4 not between", value1, value2, "shunxu4");
            return (Criteria) this;
        }

        public Criteria andShunxu5IsNull() {
            addCriterion("shunxu5 is null");
            return (Criteria) this;
        }

        public Criteria andShunxu5IsNotNull() {
            addCriterion("shunxu5 is not null");
            return (Criteria) this;
        }

        public Criteria andShunxu5EqualTo(Integer value) {
            addCriterion("shunxu5 =", value, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5NotEqualTo(Integer value) {
            addCriterion("shunxu5 <>", value, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5GreaterThan(Integer value) {
            addCriterion("shunxu5 >", value, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5GreaterThanOrEqualTo(Integer value) {
            addCriterion("shunxu5 >=", value, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5LessThan(Integer value) {
            addCriterion("shunxu5 <", value, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5LessThanOrEqualTo(Integer value) {
            addCriterion("shunxu5 <=", value, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5In(List<Integer> values) {
            addCriterion("shunxu5 in", values, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5NotIn(List<Integer> values) {
            addCriterion("shunxu5 not in", values, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5Between(Integer value1, Integer value2) {
            addCriterion("shunxu5 between", value1, value2, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu5NotBetween(Integer value1, Integer value2) {
            addCriterion("shunxu5 not between", value1, value2, "shunxu5");
            return (Criteria) this;
        }

        public Criteria andShunxu6IsNull() {
            addCriterion("shunxu6 is null");
            return (Criteria) this;
        }

        public Criteria andShunxu6IsNotNull() {
            addCriterion("shunxu6 is not null");
            return (Criteria) this;
        }

        public Criteria andShunxu6EqualTo(Integer value) {
            addCriterion("shunxu6 =", value, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6NotEqualTo(Integer value) {
            addCriterion("shunxu6 <>", value, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6GreaterThan(Integer value) {
            addCriterion("shunxu6 >", value, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6GreaterThanOrEqualTo(Integer value) {
            addCriterion("shunxu6 >=", value, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6LessThan(Integer value) {
            addCriterion("shunxu6 <", value, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6LessThanOrEqualTo(Integer value) {
            addCriterion("shunxu6 <=", value, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6In(List<Integer> values) {
            addCriterion("shunxu6 in", values, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6NotIn(List<Integer> values) {
            addCriterion("shunxu6 not in", values, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6Between(Integer value1, Integer value2) {
            addCriterion("shunxu6 between", value1, value2, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andShunxu6NotBetween(Integer value1, Integer value2) {
            addCriterion("shunxu6 not between", value1, value2, "shunxu6");
            return (Criteria) this;
        }

        public Criteria andLanIsNull() {
            addCriterion("lan is null");
            return (Criteria) this;
        }

        public Criteria andLanIsNotNull() {
            addCriterion("lan is not null");
            return (Criteria) this;
        }

        public Criteria andLanEqualTo(Integer value) {
            addCriterion("lan =", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotEqualTo(Integer value) {
            addCriterion("lan <>", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanGreaterThan(Integer value) {
            addCriterion("lan >", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanGreaterThanOrEqualTo(Integer value) {
            addCriterion("lan >=", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanLessThan(Integer value) {
            addCriterion("lan <", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanLessThanOrEqualTo(Integer value) {
            addCriterion("lan <=", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanIn(List<Integer> values) {
            addCriterion("lan in", values, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotIn(List<Integer> values) {
            addCriterion("lan not in", values, "lan");
            return (Criteria) this;
        }

        public Criteria andLanBetween(Integer value1, Integer value2) {
            addCriterion("lan between", value1, value2, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotBetween(Integer value1, Integer value2) {
            addCriterion("lan not between", value1, value2, "lan");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ssq
     *
     * @mbg.generated do_not_delete_during_merge Fri Sep 01 17:11:42 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ssq
     *
     * @mbg.generated Fri Sep 01 17:11:42 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}