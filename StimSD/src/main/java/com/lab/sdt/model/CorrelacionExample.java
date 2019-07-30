package com.lab.sdt.model;

import java.util.ArrayList;
import java.util.List;

public class CorrelacionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public CorrelacionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
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

		public Criteria andIdcorrelacionIsNull() {
			addCriterion("idCorrelacion is null");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionIsNotNull() {
			addCriterion("idCorrelacion is not null");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionEqualTo(Integer value) {
			addCriterion("idCorrelacion =", value, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionNotEqualTo(Integer value) {
			addCriterion("idCorrelacion <>", value, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionGreaterThan(Integer value) {
			addCriterion("idCorrelacion >", value, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionGreaterThanOrEqualTo(Integer value) {
			addCriterion("idCorrelacion >=", value, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionLessThan(Integer value) {
			addCriterion("idCorrelacion <", value, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionLessThanOrEqualTo(Integer value) {
			addCriterion("idCorrelacion <=", value, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionIn(List<Integer> values) {
			addCriterion("idCorrelacion in", values, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionNotIn(List<Integer> values) {
			addCriterion("idCorrelacion not in", values, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionBetween(Integer value1, Integer value2) {
			addCriterion("idCorrelacion between", value1, value2, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andIdcorrelacionNotBetween(Integer value1, Integer value2) {
			addCriterion("idCorrelacion not between", value1, value2, "idcorrelacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionIsNull() {
			addCriterion("correlacion is null");
			return (Criteria) this;
		}

		public Criteria andCorrelacionIsNotNull() {
			addCriterion("correlacion is not null");
			return (Criteria) this;
		}

		public Criteria andCorrelacionEqualTo(String value) {
			addCriterion("correlacion =", value, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionNotEqualTo(String value) {
			addCriterion("correlacion <>", value, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionGreaterThan(String value) {
			addCriterion("correlacion >", value, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionGreaterThanOrEqualTo(String value) {
			addCriterion("correlacion >=", value, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionLessThan(String value) {
			addCriterion("correlacion <", value, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionLessThanOrEqualTo(String value) {
			addCriterion("correlacion <=", value, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionLike(String value) {
			addCriterion("correlacion like", value, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionNotLike(String value) {
			addCriterion("correlacion not like", value, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionIn(List<String> values) {
			addCriterion("correlacion in", values, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionNotIn(List<String> values) {
			addCriterion("correlacion not in", values, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionBetween(String value1, String value2) {
			addCriterion("correlacion between", value1, value2, "correlacion");
			return (Criteria) this;
		}

		public Criteria andCorrelacionNotBetween(String value1, String value2) {
			addCriterion("correlacion not between", value1, value2, "correlacion");
			return (Criteria) this;
		}

		public Criteria andIdfotoIsNull() {
			addCriterion("idFoto is null");
			return (Criteria) this;
		}

		public Criteria andIdfotoIsNotNull() {
			addCriterion("idFoto is not null");
			return (Criteria) this;
		}

		public Criteria andIdfotoEqualTo(Integer value) {
			addCriterion("idFoto =", value, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoNotEqualTo(Integer value) {
			addCriterion("idFoto <>", value, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoGreaterThan(Integer value) {
			addCriterion("idFoto >", value, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoGreaterThanOrEqualTo(Integer value) {
			addCriterion("idFoto >=", value, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoLessThan(Integer value) {
			addCriterion("idFoto <", value, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoLessThanOrEqualTo(Integer value) {
			addCriterion("idFoto <=", value, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoIn(List<Integer> values) {
			addCriterion("idFoto in", values, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoNotIn(List<Integer> values) {
			addCriterion("idFoto not in", values, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoBetween(Integer value1, Integer value2) {
			addCriterion("idFoto between", value1, value2, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdfotoNotBetween(Integer value1, Integer value2) {
			addCriterion("idFoto not between", value1, value2, "idfoto");
			return (Criteria) this;
		}

		public Criteria andIdpacienteIsNull() {
			addCriterion("idPaciente is null");
			return (Criteria) this;
		}

		public Criteria andIdpacienteIsNotNull() {
			addCriterion("idPaciente is not null");
			return (Criteria) this;
		}

		public Criteria andIdpacienteEqualTo(Integer value) {
			addCriterion("idPaciente =", value, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteNotEqualTo(Integer value) {
			addCriterion("idPaciente <>", value, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteGreaterThan(Integer value) {
			addCriterion("idPaciente >", value, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteGreaterThanOrEqualTo(Integer value) {
			addCriterion("idPaciente >=", value, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteLessThan(Integer value) {
			addCriterion("idPaciente <", value, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteLessThanOrEqualTo(Integer value) {
			addCriterion("idPaciente <=", value, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteIn(List<Integer> values) {
			addCriterion("idPaciente in", values, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteNotIn(List<Integer> values) {
			addCriterion("idPaciente not in", values, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteBetween(Integer value1, Integer value2) {
			addCriterion("idPaciente between", value1, value2, "idpaciente");
			return (Criteria) this;
		}

		public Criteria andIdpacienteNotBetween(Integer value1, Integer value2) {
			addCriterion("idPaciente not between", value1, value2, "idpaciente");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table correlacion
	 * @mbg.generated  Thu Jul 25 13:18:11 CDT 2019
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table correlacion
     *
     * @mbg.generated do_not_delete_during_merge Mon May 20 14:45:29 CDT 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}