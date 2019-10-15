package com.lab.sdt.model;

import java.util.ArrayList;
import java.util.List;

public class NumOndaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public NumOndaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
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
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
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

        public Criteria andIdnumOndaIsNull() {
            addCriterion("idNum_Onda is null");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaIsNotNull() {
            addCriterion("idNum_Onda is not null");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaEqualTo(Integer value) {
            addCriterion("idNum_Onda =", value, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaNotEqualTo(Integer value) {
            addCriterion("idNum_Onda <>", value, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaGreaterThan(Integer value) {
            addCriterion("idNum_Onda >", value, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idNum_Onda >=", value, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaLessThan(Integer value) {
            addCriterion("idNum_Onda <", value, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaLessThanOrEqualTo(Integer value) {
            addCriterion("idNum_Onda <=", value, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaIn(List<Integer> values) {
            addCriterion("idNum_Onda in", values, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaNotIn(List<Integer> values) {
            addCriterion("idNum_Onda not in", values, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaBetween(Integer value1, Integer value2) {
            addCriterion("idNum_Onda between", value1, value2, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdnumOndaNotBetween(Integer value1, Integer value2) {
            addCriterion("idNum_Onda not between", value1, value2, "idnumOnda");
            return (Criteria) this;
        }

        public Criteria andIdondaIsNull() {
            addCriterion("idOnda is null");
            return (Criteria) this;
        }

        public Criteria andIdondaIsNotNull() {
            addCriterion("idOnda is not null");
            return (Criteria) this;
        }

        public Criteria andIdondaEqualTo(Integer value) {
            addCriterion("idOnda =", value, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaNotEqualTo(Integer value) {
            addCriterion("idOnda <>", value, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaGreaterThan(Integer value) {
            addCriterion("idOnda >", value, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idOnda >=", value, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaLessThan(Integer value) {
            addCriterion("idOnda <", value, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaLessThanOrEqualTo(Integer value) {
            addCriterion("idOnda <=", value, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaIn(List<Integer> values) {
            addCriterion("idOnda in", values, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaNotIn(List<Integer> values) {
            addCriterion("idOnda not in", values, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaBetween(Integer value1, Integer value2) {
            addCriterion("idOnda between", value1, value2, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdondaNotBetween(Integer value1, Integer value2) {
            addCriterion("idOnda not between", value1, value2, "idonda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaIsNull() {
            addCriterion("idTipOnda is null");
            return (Criteria) this;
        }

        public Criteria andIdtipondaIsNotNull() {
            addCriterion("idTipOnda is not null");
            return (Criteria) this;
        }

        public Criteria andIdtipondaEqualTo(Integer value) {
            addCriterion("idTipOnda =", value, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaNotEqualTo(Integer value) {
            addCriterion("idTipOnda <>", value, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaGreaterThan(Integer value) {
            addCriterion("idTipOnda >", value, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaGreaterThanOrEqualTo(Integer value) {
            addCriterion("idTipOnda >=", value, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaLessThan(Integer value) {
            addCriterion("idTipOnda <", value, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaLessThanOrEqualTo(Integer value) {
            addCriterion("idTipOnda <=", value, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaIn(List<Integer> values) {
            addCriterion("idTipOnda in", values, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaNotIn(List<Integer> values) {
            addCriterion("idTipOnda not in", values, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaBetween(Integer value1, Integer value2) {
            addCriterion("idTipOnda between", value1, value2, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andIdtipondaNotBetween(Integer value1, Integer value2) {
            addCriterion("idTipOnda not between", value1, value2, "idtiponda");
            return (Criteria) this;
        }

        public Criteria andNombreIsNull() {
            addCriterion("nombre is null");
            return (Criteria) this;
        }

        public Criteria andNombreIsNotNull() {
            addCriterion("nombre is not null");
            return (Criteria) this;
        }

        public Criteria andNombreEqualTo(String value) {
            addCriterion("nombre =", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotEqualTo(String value) {
            addCriterion("nombre <>", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThan(String value) {
            addCriterion("nombre >", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThanOrEqualTo(String value) {
            addCriterion("nombre >=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThan(String value) {
            addCriterion("nombre <", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThanOrEqualTo(String value) {
            addCriterion("nombre <=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLike(String value) {
            addCriterion("nombre like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotLike(String value) {
            addCriterion("nombre not like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreIn(List<String> values) {
            addCriterion("nombre in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotIn(List<String> values) {
            addCriterion("nombre not in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreBetween(String value1, String value2) {
            addCriterion("nombre between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotBetween(String value1, String value2) {
            addCriterion("nombre not between", value1, value2, "nombre");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table num_onda
     *
     * @mbg.generated do_not_delete_during_merge Thu Jul 25 13:21:07 CDT 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table num_onda
     *
     * @mbg.generated Thu Jul 25 13:21:07 CDT 2019
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