package com.sauzny.sb_mybatis_mds.entity.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IncomeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIncomeDateIsNull() {
            addCriterion("income_date is null");
            return (Criteria) this;
        }

        public Criteria andIncomeDateIsNotNull() {
            addCriterion("income_date is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeDateEqualTo(Date value) {
            addCriterion("income_date =", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateNotEqualTo(Date value) {
            addCriterion("income_date <>", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateGreaterThan(Date value) {
            addCriterion("income_date >", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("income_date >=", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateLessThan(Date value) {
            addCriterion("income_date <", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateLessThanOrEqualTo(Date value) {
            addCriterion("income_date <=", value, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateIn(List<Date> values) {
            addCriterion("income_date in", values, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateNotIn(List<Date> values) {
            addCriterion("income_date not in", values, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateBetween(Date value1, Date value2) {
            addCriterion("income_date between", value1, value2, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andIncomeDateNotBetween(Date value1, Date value2) {
            addCriterion("income_date not between", value1, value2, "incomeDate");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIsNull() {
            addCriterion("total_income is null");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIsNotNull() {
            addCriterion("total_income is not null");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeEqualTo(Integer value) {
            addCriterion("total_income =", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotEqualTo(Integer value) {
            addCriterion("total_income <>", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeGreaterThan(Integer value) {
            addCriterion("total_income >", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_income >=", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeLessThan(Integer value) {
            addCriterion("total_income <", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("total_income <=", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIn(List<Integer> values) {
            addCriterion("total_income in", values, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotIn(List<Integer> values) {
            addCriterion("total_income not in", values, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeBetween(Integer value1, Integer value2) {
            addCriterion("total_income between", value1, value2, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("total_income not between", value1, value2, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionIsNull() {
            addCriterion("total_commission is null");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionIsNotNull() {
            addCriterion("total_commission is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionEqualTo(Integer value) {
            addCriterion("total_commission =", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionNotEqualTo(Integer value) {
            addCriterion("total_commission <>", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionGreaterThan(Integer value) {
            addCriterion("total_commission >", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_commission >=", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionLessThan(Integer value) {
            addCriterion("total_commission <", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("total_commission <=", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionIn(List<Integer> values) {
            addCriterion("total_commission in", values, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionNotIn(List<Integer> values) {
            addCriterion("total_commission not in", values, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionBetween(Integer value1, Integer value2) {
            addCriterion("total_commission between", value1, value2, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("total_commission not between", value1, value2, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeIsNull() {
            addCriterion("total_proxy_income is null");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeIsNotNull() {
            addCriterion("total_proxy_income is not null");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeEqualTo(Integer value) {
            addCriterion("total_proxy_income =", value, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeNotEqualTo(Integer value) {
            addCriterion("total_proxy_income <>", value, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeGreaterThan(Integer value) {
            addCriterion("total_proxy_income >", value, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_proxy_income >=", value, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeLessThan(Integer value) {
            addCriterion("total_proxy_income <", value, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("total_proxy_income <=", value, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeIn(List<Integer> values) {
            addCriterion("total_proxy_income in", values, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeNotIn(List<Integer> values) {
            addCriterion("total_proxy_income not in", values, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeBetween(Integer value1, Integer value2) {
            addCriterion("total_proxy_income between", value1, value2, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andTotalProxyIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("total_proxy_income not between", value1, value2, "totalProxyIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIsNull() {
            addCriterion("net_income is null");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIsNotNull() {
            addCriterion("net_income is not null");
            return (Criteria) this;
        }

        public Criteria andNetIncomeEqualTo(Integer value) {
            addCriterion("net_income =", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotEqualTo(Integer value) {
            addCriterion("net_income <>", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeGreaterThan(Integer value) {
            addCriterion("net_income >", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_income >=", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeLessThan(Integer value) {
            addCriterion("net_income <", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("net_income <=", value, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeIn(List<Integer> values) {
            addCriterion("net_income in", values, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotIn(List<Integer> values) {
            addCriterion("net_income not in", values, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeBetween(Integer value1, Integer value2) {
            addCriterion("net_income between", value1, value2, "netIncome");
            return (Criteria) this;
        }

        public Criteria andNetIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("net_income not between", value1, value2, "netIncome");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(Integer value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(Integer value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(Integer value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(Integer value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<Integer> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<Integer> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(Integer value1, Integer value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeIsNull() {
            addCriterion("proxy_income is null");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeIsNotNull() {
            addCriterion("proxy_income is not null");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeEqualTo(Integer value) {
            addCriterion("proxy_income =", value, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeNotEqualTo(Integer value) {
            addCriterion("proxy_income <>", value, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeGreaterThan(Integer value) {
            addCriterion("proxy_income >", value, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("proxy_income >=", value, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeLessThan(Integer value) {
            addCriterion("proxy_income <", value, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("proxy_income <=", value, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeIn(List<Integer> values) {
            addCriterion("proxy_income in", values, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeNotIn(List<Integer> values) {
            addCriterion("proxy_income not in", values, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeBetween(Integer value1, Integer value2) {
            addCriterion("proxy_income between", value1, value2, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andProxyIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("proxy_income not between", value1, value2, "proxyIncome");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNull() {
            addCriterion("order_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNotNull() {
            addCriterion("order_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountEqualTo(Integer value) {
            addCriterion("order_count =", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotEqualTo(Integer value) {
            addCriterion("order_count <>", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThan(Integer value) {
            addCriterion("order_count >", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count >=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThan(Integer value) {
            addCriterion("order_count <", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_count <=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIn(List<Integer> values) {
            addCriterion("order_count in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotIn(List<Integer> values) {
            addCriterion("order_count not in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("order_count between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count not between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountIsNull() {
            addCriterion("proxy_new_count is null");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountIsNotNull() {
            addCriterion("proxy_new_count is not null");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountEqualTo(Integer value) {
            addCriterion("proxy_new_count =", value, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountNotEqualTo(Integer value) {
            addCriterion("proxy_new_count <>", value, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountGreaterThan(Integer value) {
            addCriterion("proxy_new_count >", value, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("proxy_new_count >=", value, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountLessThan(Integer value) {
            addCriterion("proxy_new_count <", value, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountLessThanOrEqualTo(Integer value) {
            addCriterion("proxy_new_count <=", value, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountIn(List<Integer> values) {
            addCriterion("proxy_new_count in", values, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountNotIn(List<Integer> values) {
            addCriterion("proxy_new_count not in", values, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountBetween(Integer value1, Integer value2) {
            addCriterion("proxy_new_count between", value1, value2, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andProxyNewCountNotBetween(Integer value1, Integer value2) {
            addCriterion("proxy_new_count not between", value1, value2, "proxyNewCount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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