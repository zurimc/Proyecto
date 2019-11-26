package com.lab.sdt.model;

import java.util.ArrayList;
import java.util.List;

public class HospitalExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public HospitalExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
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

		public Criteria andIdhospitalIsNull() {
			addCriterion("idHospital is null");
			return (Criteria) this;
		}

		public Criteria andIdhospitalIsNotNull() {
			addCriterion("idHospital is not null");
			return (Criteria) this;
		}

		public Criteria andIdhospitalEqualTo(Integer value) {
			addCriterion("idHospital =", value, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalNotEqualTo(Integer value) {
			addCriterion("idHospital <>", value, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalGreaterThan(Integer value) {
			addCriterion("idHospital >", value, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalGreaterThanOrEqualTo(Integer value) {
			addCriterion("idHospital >=", value, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalLessThan(Integer value) {
			addCriterion("idHospital <", value, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalLessThanOrEqualTo(Integer value) {
			addCriterion("idHospital <=", value, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalIn(List<Integer> values) {
			addCriterion("idHospital in", values, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalNotIn(List<Integer> values) {
			addCriterion("idHospital not in", values, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalBetween(Integer value1, Integer value2) {
			addCriterion("idHospital between", value1, value2, "idhospital");
			return (Criteria) this;
		}

		public Criteria andIdhospitalNotBetween(Integer value1, Integer value2) {
			addCriterion("idHospital not between", value1, value2, "idhospital");
			return (Criteria) this;
		}

		public Criteria andHospitalIsNull() {
			addCriterion("hospital is null");
			return (Criteria) this;
		}

		public Criteria andHospitalIsNotNull() {
			addCriterion("hospital is not null");
			return (Criteria) this;
		}

		public Criteria andHospitalEqualTo(String value) {
			addCriterion("hospital =", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalNotEqualTo(String value) {
			addCriterion("hospital <>", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalGreaterThan(String value) {
			addCriterion("hospital >", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalGreaterThanOrEqualTo(String value) {
			addCriterion("hospital >=", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalLessThan(String value) {
			addCriterion("hospital <", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalLessThanOrEqualTo(String value) {
			addCriterion("hospital <=", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalLike(String value) {
			addCriterion("hospital like", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalNotLike(String value) {
			addCriterion("hospital not like", value, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalIn(List<String> values) {
			addCriterion("hospital in", values, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalNotIn(List<String> values) {
			addCriterion("hospital not in", values, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalBetween(String value1, String value2) {
			addCriterion("hospital between", value1, value2, "hospital");
			return (Criteria) this;
		}

		public Criteria andHospitalNotBetween(String value1, String value2) {
			addCriterion("hospital not between", value1, value2, "hospital");
			return (Criteria) this;
		}

		public Criteria andCalleIsNull() {
			addCriterion("calle is null");
			return (Criteria) this;
		}

		public Criteria andCalleIsNotNull() {
			addCriterion("calle is not null");
			return (Criteria) this;
		}

		public Criteria andCalleEqualTo(String value) {
			addCriterion("calle =", value, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleNotEqualTo(String value) {
			addCriterion("calle <>", value, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleGreaterThan(String value) {
			addCriterion("calle >", value, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleGreaterThanOrEqualTo(String value) {
			addCriterion("calle >=", value, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleLessThan(String value) {
			addCriterion("calle <", value, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleLessThanOrEqualTo(String value) {
			addCriterion("calle <=", value, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleLike(String value) {
			addCriterion("calle like", value, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleNotLike(String value) {
			addCriterion("calle not like", value, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleIn(List<String> values) {
			addCriterion("calle in", values, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleNotIn(List<String> values) {
			addCriterion("calle not in", values, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleBetween(String value1, String value2) {
			addCriterion("calle between", value1, value2, "calle");
			return (Criteria) this;
		}

		public Criteria andCalleNotBetween(String value1, String value2) {
			addCriterion("calle not between", value1, value2, "calle");
			return (Criteria) this;
		}

		public Criteria andNumeroIsNull() {
			addCriterion("numero is null");
			return (Criteria) this;
		}

		public Criteria andNumeroIsNotNull() {
			addCriterion("numero is not null");
			return (Criteria) this;
		}

		public Criteria andNumeroEqualTo(Integer value) {
			addCriterion("numero =", value, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroNotEqualTo(Integer value) {
			addCriterion("numero <>", value, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroGreaterThan(Integer value) {
			addCriterion("numero >", value, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroGreaterThanOrEqualTo(Integer value) {
			addCriterion("numero >=", value, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroLessThan(Integer value) {
			addCriterion("numero <", value, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroLessThanOrEqualTo(Integer value) {
			addCriterion("numero <=", value, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroIn(List<Integer> values) {
			addCriterion("numero in", values, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroNotIn(List<Integer> values) {
			addCriterion("numero not in", values, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroBetween(Integer value1, Integer value2) {
			addCriterion("numero between", value1, value2, "numero");
			return (Criteria) this;
		}

		public Criteria andNumeroNotBetween(Integer value1, Integer value2) {
			addCriterion("numero not between", value1, value2, "numero");
			return (Criteria) this;
		}

		public Criteria andColoniaIsNull() {
			addCriterion("colonia is null");
			return (Criteria) this;
		}

		public Criteria andColoniaIsNotNull() {
			addCriterion("colonia is not null");
			return (Criteria) this;
		}

		public Criteria andColoniaEqualTo(String value) {
			addCriterion("colonia =", value, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaNotEqualTo(String value) {
			addCriterion("colonia <>", value, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaGreaterThan(String value) {
			addCriterion("colonia >", value, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaGreaterThanOrEqualTo(String value) {
			addCriterion("colonia >=", value, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaLessThan(String value) {
			addCriterion("colonia <", value, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaLessThanOrEqualTo(String value) {
			addCriterion("colonia <=", value, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaLike(String value) {
			addCriterion("colonia like", value, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaNotLike(String value) {
			addCriterion("colonia not like", value, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaIn(List<String> values) {
			addCriterion("colonia in", values, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaNotIn(List<String> values) {
			addCriterion("colonia not in", values, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaBetween(String value1, String value2) {
			addCriterion("colonia between", value1, value2, "colonia");
			return (Criteria) this;
		}

		public Criteria andColoniaNotBetween(String value1, String value2) {
			addCriterion("colonia not between", value1, value2, "colonia");
			return (Criteria) this;
		}

		public Criteria andCodigopostalIsNull() {
			addCriterion("codigoPostal is null");
			return (Criteria) this;
		}

		public Criteria andCodigopostalIsNotNull() {
			addCriterion("codigoPostal is not null");
			return (Criteria) this;
		}

		public Criteria andCodigopostalEqualTo(String value) {
			addCriterion("codigoPostal =", value, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalNotEqualTo(String value) {
			addCriterion("codigoPostal <>", value, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalGreaterThan(String value) {
			addCriterion("codigoPostal >", value, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalGreaterThanOrEqualTo(String value) {
			addCriterion("codigoPostal >=", value, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalLessThan(String value) {
			addCriterion("codigoPostal <", value, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalLessThanOrEqualTo(String value) {
			addCriterion("codigoPostal <=", value, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalLike(String value) {
			addCriterion("codigoPostal like", value, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalNotLike(String value) {
			addCriterion("codigoPostal not like", value, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalIn(List<String> values) {
			addCriterion("codigoPostal in", values, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalNotIn(List<String> values) {
			addCriterion("codigoPostal not in", values, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalBetween(String value1, String value2) {
			addCriterion("codigoPostal between", value1, value2, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andCodigopostalNotBetween(String value1, String value2) {
			addCriterion("codigoPostal not between", value1, value2, "codigopostal");
			return (Criteria) this;
		}

		public Criteria andIdestadoIsNull() {
			addCriterion("idEstado is null");
			return (Criteria) this;
		}

		public Criteria andIdestadoIsNotNull() {
			addCriterion("idEstado is not null");
			return (Criteria) this;
		}

		public Criteria andIdestadoEqualTo(Integer value) {
			addCriterion("idEstado =", value, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoNotEqualTo(Integer value) {
			addCriterion("idEstado <>", value, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoGreaterThan(Integer value) {
			addCriterion("idEstado >", value, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoGreaterThanOrEqualTo(Integer value) {
			addCriterion("idEstado >=", value, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoLessThan(Integer value) {
			addCriterion("idEstado <", value, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoLessThanOrEqualTo(Integer value) {
			addCriterion("idEstado <=", value, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoIn(List<Integer> values) {
			addCriterion("idEstado in", values, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoNotIn(List<Integer> values) {
			addCriterion("idEstado not in", values, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoBetween(Integer value1, Integer value2) {
			addCriterion("idEstado between", value1, value2, "idestado");
			return (Criteria) this;
		}

		public Criteria andIdestadoNotBetween(Integer value1, Integer value2) {
			addCriterion("idEstado not between", value1, value2, "idestado");
			return (Criteria) this;
		}

		public Criteria andTelefonoIsNull() {
			addCriterion("telefono is null");
			return (Criteria) this;
		}

		public Criteria andTelefonoIsNotNull() {
			addCriterion("telefono is not null");
			return (Criteria) this;
		}

		public Criteria andTelefonoEqualTo(String value) {
			addCriterion("telefono =", value, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoNotEqualTo(String value) {
			addCriterion("telefono <>", value, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoGreaterThan(String value) {
			addCriterion("telefono >", value, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoGreaterThanOrEqualTo(String value) {
			addCriterion("telefono >=", value, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoLessThan(String value) {
			addCriterion("telefono <", value, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoLessThanOrEqualTo(String value) {
			addCriterion("telefono <=", value, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoLike(String value) {
			addCriterion("telefono like", value, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoNotLike(String value) {
			addCriterion("telefono not like", value, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoIn(List<String> values) {
			addCriterion("telefono in", values, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoNotIn(List<String> values) {
			addCriterion("telefono not in", values, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoBetween(String value1, String value2) {
			addCriterion("telefono between", value1, value2, "telefono");
			return (Criteria) this;
		}

		public Criteria andTelefonoNotBetween(String value1, String value2) {
			addCriterion("telefono not between", value1, value2, "telefono");
			return (Criteria) this;
		}

		public Criteria andEstatusIsNull() {
			addCriterion("estatus is null");
			return (Criteria) this;
		}

		public Criteria andEstatusIsNotNull() {
			addCriterion("estatus is not null");
			return (Criteria) this;
		}

		public Criteria andEstatusEqualTo(String value) {
			addCriterion("estatus =", value, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusNotEqualTo(String value) {
			addCriterion("estatus <>", value, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusGreaterThan(String value) {
			addCriterion("estatus >", value, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusGreaterThanOrEqualTo(String value) {
			addCriterion("estatus >=", value, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusLessThan(String value) {
			addCriterion("estatus <", value, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusLessThanOrEqualTo(String value) {
			addCriterion("estatus <=", value, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusLike(String value) {
			addCriterion("estatus like", value, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusNotLike(String value) {
			addCriterion("estatus not like", value, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusIn(List<String> values) {
			addCriterion("estatus in", values, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusNotIn(List<String> values) {
			addCriterion("estatus not in", values, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusBetween(String value1, String value2) {
			addCriterion("estatus between", value1, value2, "estatus");
			return (Criteria) this;
		}

		public Criteria andEstatusNotBetween(String value1, String value2) {
			addCriterion("estatus not between", value1, value2, "estatus");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hospital
	 * @mbg.generated  Tue Nov 26 16:14:00 CST 2019
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
     * This class corresponds to the database table hospital
     *
     * @mbg.generated do_not_delete_during_merge Wed Aug 14 13:34:54 CDT 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}