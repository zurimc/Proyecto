package com.lab.sdt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MantenimientoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public MantenimientoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
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
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
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

        public Criteria andIdmantenimientoIsNull() {
            addCriterion("idMantenimiento is null");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoIsNotNull() {
            addCriterion("idMantenimiento is not null");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoEqualTo(Integer value) {
            addCriterion("idMantenimiento =", value, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoNotEqualTo(Integer value) {
            addCriterion("idMantenimiento <>", value, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoGreaterThan(Integer value) {
            addCriterion("idMantenimiento >", value, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoGreaterThanOrEqualTo(Integer value) {
            addCriterion("idMantenimiento >=", value, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoLessThan(Integer value) {
            addCriterion("idMantenimiento <", value, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoLessThanOrEqualTo(Integer value) {
            addCriterion("idMantenimiento <=", value, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoIn(List<Integer> values) {
            addCriterion("idMantenimiento in", values, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoNotIn(List<Integer> values) {
            addCriterion("idMantenimiento not in", values, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoBetween(Integer value1, Integer value2) {
            addCriterion("idMantenimiento between", value1, value2, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andIdmantenimientoNotBetween(Integer value1, Integer value2) {
            addCriterion("idMantenimiento not between", value1, value2, "idmantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoIsNull() {
            addCriterion("fechaMantenimiento is null");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoIsNotNull() {
            addCriterion("fechaMantenimiento is not null");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoEqualTo(Date value) {
            addCriterionForJDBCDate("fechaMantenimiento =", value, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoNotEqualTo(Date value) {
            addCriterionForJDBCDate("fechaMantenimiento <>", value, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoGreaterThan(Date value) {
            addCriterionForJDBCDate("fechaMantenimiento >", value, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fechaMantenimiento >=", value, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoLessThan(Date value) {
            addCriterionForJDBCDate("fechaMantenimiento <", value, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fechaMantenimiento <=", value, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoIn(List<Date> values) {
            addCriterionForJDBCDate("fechaMantenimiento in", values, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoNotIn(List<Date> values) {
            addCriterionForJDBCDate("fechaMantenimiento not in", values, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fechaMantenimiento between", value1, value2, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFechamantenimientoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fechaMantenimiento not between", value1, value2, "fechamantenimiento");
            return (Criteria) this;
        }

        public Criteria andFallaIsNull() {
            addCriterion("falla is null");
            return (Criteria) this;
        }

        public Criteria andFallaIsNotNull() {
            addCriterion("falla is not null");
            return (Criteria) this;
        }

        public Criteria andFallaEqualTo(String value) {
            addCriterion("falla =", value, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaNotEqualTo(String value) {
            addCriterion("falla <>", value, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaGreaterThan(String value) {
            addCriterion("falla >", value, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaGreaterThanOrEqualTo(String value) {
            addCriterion("falla >=", value, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaLessThan(String value) {
            addCriterion("falla <", value, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaLessThanOrEqualTo(String value) {
            addCriterion("falla <=", value, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaLike(String value) {
            addCriterion("falla like", value, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaNotLike(String value) {
            addCriterion("falla not like", value, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaIn(List<String> values) {
            addCriterion("falla in", values, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaNotIn(List<String> values) {
            addCriterion("falla not in", values, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaBetween(String value1, String value2) {
            addCriterion("falla between", value1, value2, "falla");
            return (Criteria) this;
        }

        public Criteria andFallaNotBetween(String value1, String value2) {
            addCriterion("falla not between", value1, value2, "falla");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionIsNull() {
            addCriterion("tipoActualizacion is null");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionIsNotNull() {
            addCriterion("tipoActualizacion is not null");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionEqualTo(String value) {
            addCriterion("tipoActualizacion =", value, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionNotEqualTo(String value) {
            addCriterion("tipoActualizacion <>", value, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionGreaterThan(String value) {
            addCriterion("tipoActualizacion >", value, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionGreaterThanOrEqualTo(String value) {
            addCriterion("tipoActualizacion >=", value, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionLessThan(String value) {
            addCriterion("tipoActualizacion <", value, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionLessThanOrEqualTo(String value) {
            addCriterion("tipoActualizacion <=", value, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionLike(String value) {
            addCriterion("tipoActualizacion like", value, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionNotLike(String value) {
            addCriterion("tipoActualizacion not like", value, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionIn(List<String> values) {
            addCriterion("tipoActualizacion in", values, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionNotIn(List<String> values) {
            addCriterion("tipoActualizacion not in", values, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionBetween(String value1, String value2) {
            addCriterion("tipoActualizacion between", value1, value2, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andTipoactualizacionNotBetween(String value1, String value2) {
            addCriterion("tipoActualizacion not between", value1, value2, "tipoactualizacion");
            return (Criteria) this;
        }

        public Criteria andIdusuarioIsNull() {
            addCriterion("idUsuario is null");
            return (Criteria) this;
        }

        public Criteria andIdusuarioIsNotNull() {
            addCriterion("idUsuario is not null");
            return (Criteria) this;
        }

        public Criteria andIdusuarioEqualTo(Integer value) {
            addCriterion("idUsuario =", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioNotEqualTo(Integer value) {
            addCriterion("idUsuario <>", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioGreaterThan(Integer value) {
            addCriterion("idUsuario >", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioGreaterThanOrEqualTo(Integer value) {
            addCriterion("idUsuario >=", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioLessThan(Integer value) {
            addCriterion("idUsuario <", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioLessThanOrEqualTo(Integer value) {
            addCriterion("idUsuario <=", value, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioIn(List<Integer> values) {
            addCriterion("idUsuario in", values, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioNotIn(List<Integer> values) {
            addCriterion("idUsuario not in", values, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioBetween(Integer value1, Integer value2) {
            addCriterion("idUsuario between", value1, value2, "idusuario");
            return (Criteria) this;
        }

        public Criteria andIdusuarioNotBetween(Integer value1, Integer value2) {
            addCriterion("idUsuario not between", value1, value2, "idusuario");
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

        public Criteria andLonguitudIsNull() {
            addCriterion("longuitud is null");
            return (Criteria) this;
        }

        public Criteria andLonguitudIsNotNull() {
            addCriterion("longuitud is not null");
            return (Criteria) this;
        }

        public Criteria andLonguitudEqualTo(String value) {
            addCriterion("longuitud =", value, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudNotEqualTo(String value) {
            addCriterion("longuitud <>", value, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudGreaterThan(String value) {
            addCriterion("longuitud >", value, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudGreaterThanOrEqualTo(String value) {
            addCriterion("longuitud >=", value, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudLessThan(String value) {
            addCriterion("longuitud <", value, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudLessThanOrEqualTo(String value) {
            addCriterion("longuitud <=", value, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudLike(String value) {
            addCriterion("longuitud like", value, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudNotLike(String value) {
            addCriterion("longuitud not like", value, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudIn(List<String> values) {
            addCriterion("longuitud in", values, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudNotIn(List<String> values) {
            addCriterion("longuitud not in", values, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudBetween(String value1, String value2) {
            addCriterion("longuitud between", value1, value2, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLonguitudNotBetween(String value1, String value2) {
            addCriterion("longuitud not between", value1, value2, "longuitud");
            return (Criteria) this;
        }

        public Criteria andLatitudIsNull() {
            addCriterion("latitud is null");
            return (Criteria) this;
        }

        public Criteria andLatitudIsNotNull() {
            addCriterion("latitud is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudEqualTo(String value) {
            addCriterion("latitud =", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudNotEqualTo(String value) {
            addCriterion("latitud <>", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudGreaterThan(String value) {
            addCriterion("latitud >", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudGreaterThanOrEqualTo(String value) {
            addCriterion("latitud >=", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudLessThan(String value) {
            addCriterion("latitud <", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudLessThanOrEqualTo(String value) {
            addCriterion("latitud <=", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudLike(String value) {
            addCriterion("latitud like", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudNotLike(String value) {
            addCriterion("latitud not like", value, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudIn(List<String> values) {
            addCriterion("latitud in", values, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudNotIn(List<String> values) {
            addCriterion("latitud not in", values, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudBetween(String value1, String value2) {
            addCriterion("latitud between", value1, value2, "latitud");
            return (Criteria) this;
        }

        public Criteria andLatitudNotBetween(String value1, String value2) {
            addCriterion("latitud not between", value1, value2, "latitud");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mantenimiento
     *
     * @mbg.generated do_not_delete_during_merge Sat Aug 24 17:39:43 CDT 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mantenimiento
     *
     * @mbg.generated Sat Aug 24 17:39:43 CDT 2019
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