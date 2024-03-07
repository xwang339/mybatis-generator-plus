package org.mybatis.generator.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lixin
 * @date 2024-03-07 17:22:11
 * modelExampleClassGenerated
 */
public class UsersExample {
    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    protected String orderByClause;

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    protected boolean distinct;

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public UsersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2024-03-07 17:22:11
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Users
     *
     * @mbg.generated 2024-03-07 17:22:11
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCharTestIsNull() {
            addCriterion("char_test is null");
            return (Criteria) this;
        }

        public Criteria andCharTestIsNotNull() {
            addCriterion("char_test is not null");
            return (Criteria) this;
        }

        public Criteria andCharTestEqualTo(String value) {
            addCriterion("char_test =", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestNotEqualTo(String value) {
            addCriterion("char_test <>", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestGreaterThan(String value) {
            addCriterion("char_test >", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestGreaterThanOrEqualTo(String value) {
            addCriterion("char_test >=", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestLessThan(String value) {
            addCriterion("char_test <", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestLessThanOrEqualTo(String value) {
            addCriterion("char_test <=", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestLike(String value) {
            addCriterion("char_test like", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestNotLike(String value) {
            addCriterion("char_test not like", value, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestIn(List<String> values) {
            addCriterion("char_test in", values, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestNotIn(List<String> values) {
            addCriterion("char_test not in", values, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestBetween(String value1, String value2) {
            addCriterion("char_test between", value1, value2, "charTest");
            return (Criteria) this;
        }

        public Criteria andCharTestNotBetween(String value1, String value2) {
            addCriterion("char_test not between", value1, value2, "charTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestIsNull() {
            addCriterion("timestamp_test is null");
            return (Criteria) this;
        }

        public Criteria andTimestampTestIsNotNull() {
            addCriterion("timestamp_test is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampTestEqualTo(Date value) {
            addCriterion("timestamp_test =", value, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestNotEqualTo(Date value) {
            addCriterion("timestamp_test <>", value, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestGreaterThan(Date value) {
            addCriterion("timestamp_test >", value, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp_test >=", value, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestLessThan(Date value) {
            addCriterion("timestamp_test <", value, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestLessThanOrEqualTo(Date value) {
            addCriterion("timestamp_test <=", value, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestIn(List<Date> values) {
            addCriterion("timestamp_test in", values, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestNotIn(List<Date> values) {
            addCriterion("timestamp_test not in", values, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestBetween(Date value1, Date value2) {
            addCriterion("timestamp_test between", value1, value2, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andTimestampTestNotBetween(Date value1, Date value2) {
            addCriterion("timestamp_test not between", value1, value2, "timestampTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestIsNull() {
            addCriterion("datetime_test is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestIsNotNull() {
            addCriterion("datetime_test is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestEqualTo(Date value) {
            addCriterion("datetime_test =", value, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestNotEqualTo(Date value) {
            addCriterion("datetime_test <>", value, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestGreaterThan(Date value) {
            addCriterion("datetime_test >", value, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestGreaterThanOrEqualTo(Date value) {
            addCriterion("datetime_test >=", value, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestLessThan(Date value) {
            addCriterion("datetime_test <", value, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestLessThanOrEqualTo(Date value) {
            addCriterion("datetime_test <=", value, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestIn(List<Date> values) {
            addCriterion("datetime_test in", values, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestNotIn(List<Date> values) {
            addCriterion("datetime_test not in", values, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestBetween(Date value1, Date value2) {
            addCriterion("datetime_test between", value1, value2, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andDatetimeTestNotBetween(Date value1, Date value2) {
            addCriterion("datetime_test not between", value1, value2, "datetimeTest");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Users
     *
     * @mbg.generated do_not_delete_during_merge 2024-03-07 17:22:11
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Users
     *
     * @mbg.generated 2024-03-07 17:22:11
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