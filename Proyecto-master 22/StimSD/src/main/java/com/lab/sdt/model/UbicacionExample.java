package com.lab.sdt.model;

import java.util.ArrayList;
import java.util.List;

public class UbicacionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public UbicacionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
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
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
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

        public Criteria andIdestimulacionIsNull() {
            addCriterion("idEstimulacion is null");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionIsNotNull() {
            addCriterion("idEstimulacion is not null");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionEqualTo(Integer value) {
            addCriterion("idEstimulacion =", value, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionNotEqualTo(Integer value) {
            addCriterion("idEstimulacion <>", value, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionGreaterThan(Integer value) {
            addCriterion("idEstimulacion >", value, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionGreaterThanOrEqualTo(Integer value) {
            addCriterion("idEstimulacion >=", value, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionLessThan(Integer value) {
            addCriterion("idEstimulacion <", value, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionLessThanOrEqualTo(Integer value) {
            addCriterion("idEstimulacion <=", value, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionIn(List<Integer> values) {
            addCriterion("idEstimulacion in", values, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionNotIn(List<Integer> values) {
            addCriterion("idEstimulacion not in", values, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionBetween(Integer value1, Integer value2) {
            addCriterion("idEstimulacion between", value1, value2, "idestimulacion");
            return (Criteria) this;
        }

        public Criteria andIdestimulacionNotBetween(Integer value1, Integer value2) {
            addCriterion("idEstimulacion not between", value1, value2, "idestimulacion");
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

        public Criteria andAmplitudIsNull() {
            addCriterion("amplitud is null");
            return (Criteria) this;
        }

        public Criteria andAmplitudIsNotNull() {
            addCriterion("amplitud is not null");
            return (Criteria) this;
        }

        public Criteria andAmplitudEqualTo(String value) {
            addCriterion("amplitud =", value, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudNotEqualTo(String value) {
            addCriterion("amplitud <>", value, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudGreaterThan(String value) {
            addCriterion("amplitud >", value, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudGreaterThanOrEqualTo(String value) {
            addCriterion("amplitud >=", value, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudLessThan(String value) {
            addCriterion("amplitud <", value, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudLessThanOrEqualTo(String value) {
            addCriterion("amplitud <=", value, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudLike(String value) {
            addCriterion("amplitud like", value, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudNotLike(String value) {
            addCriterion("amplitud not like", value, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudIn(List<String> values) {
            addCriterion("amplitud in", values, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudNotIn(List<String> values) {
            addCriterion("amplitud not in", values, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudBetween(String value1, String value2) {
            addCriterion("amplitud between", value1, value2, "amplitud");
            return (Criteria) this;
        }

        public Criteria andAmplitudNotBetween(String value1, String value2) {
            addCriterion("amplitud not between", value1, value2, "amplitud");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaIsNull() {
            addCriterion("frecuencia is null");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaIsNotNull() {
            addCriterion("frecuencia is not null");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaEqualTo(String value) {
            addCriterion("frecuencia =", value, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaNotEqualTo(String value) {
            addCriterion("frecuencia <>", value, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaGreaterThan(String value) {
            addCriterion("frecuencia >", value, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaGreaterThanOrEqualTo(String value) {
            addCriterion("frecuencia >=", value, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaLessThan(String value) {
            addCriterion("frecuencia <", value, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaLessThanOrEqualTo(String value) {
            addCriterion("frecuencia <=", value, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaLike(String value) {
            addCriterion("frecuencia like", value, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaNotLike(String value) {
            addCriterion("frecuencia not like", value, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaIn(List<String> values) {
            addCriterion("frecuencia in", values, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaNotIn(List<String> values) {
            addCriterion("frecuencia not in", values, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaBetween(String value1, String value2) {
            addCriterion("frecuencia between", value1, value2, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andFrecuenciaNotBetween(String value1, String value2) {
            addCriterion("frecuencia not between", value1, value2, "frecuencia");
            return (Criteria) this;
        }

        public Criteria andTiempoIsNull() {
            addCriterion("tiempo is null");
            return (Criteria) this;
        }

        public Criteria andTiempoIsNotNull() {
            addCriterion("tiempo is not null");
            return (Criteria) this;
        }

        public Criteria andTiempoEqualTo(String value) {
            addCriterion("tiempo =", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotEqualTo(String value) {
            addCriterion("tiempo <>", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoGreaterThan(String value) {
            addCriterion("tiempo >", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoGreaterThanOrEqualTo(String value) {
            addCriterion("tiempo >=", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoLessThan(String value) {
            addCriterion("tiempo <", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoLessThanOrEqualTo(String value) {
            addCriterion("tiempo <=", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoLike(String value) {
            addCriterion("tiempo like", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotLike(String value) {
            addCriterion("tiempo not like", value, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoIn(List<String> values) {
            addCriterion("tiempo in", values, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotIn(List<String> values) {
            addCriterion("tiempo not in", values, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoBetween(String value1, String value2) {
            addCriterion("tiempo between", value1, value2, "tiempo");
            return (Criteria) this;
        }

        public Criteria andTiempoNotBetween(String value1, String value2) {
            addCriterion("tiempo not between", value1, value2, "tiempo");
            return (Criteria) this;
        }

        public Criteria andOndaP1IsNull() {
            addCriterion("onda_P1 is null");
            return (Criteria) this;
        }

        public Criteria andOndaP1IsNotNull() {
            addCriterion("onda_P1 is not null");
            return (Criteria) this;
        }

        public Criteria andOndaP1EqualTo(String value) {
            addCriterion("onda_P1 =", value, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1NotEqualTo(String value) {
            addCriterion("onda_P1 <>", value, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1GreaterThan(String value) {
            addCriterion("onda_P1 >", value, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1GreaterThanOrEqualTo(String value) {
            addCriterion("onda_P1 >=", value, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1LessThan(String value) {
            addCriterion("onda_P1 <", value, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1LessThanOrEqualTo(String value) {
            addCriterion("onda_P1 <=", value, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1Like(String value) {
            addCriterion("onda_P1 like", value, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1NotLike(String value) {
            addCriterion("onda_P1 not like", value, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1In(List<String> values) {
            addCriterion("onda_P1 in", values, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1NotIn(List<String> values) {
            addCriterion("onda_P1 not in", values, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1Between(String value1, String value2) {
            addCriterion("onda_P1 between", value1, value2, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP1NotBetween(String value1, String value2) {
            addCriterion("onda_P1 not between", value1, value2, "ondaP1");
            return (Criteria) this;
        }

        public Criteria andOndaP2IsNull() {
            addCriterion("onda_P2 is null");
            return (Criteria) this;
        }

        public Criteria andOndaP2IsNotNull() {
            addCriterion("onda_P2 is not null");
            return (Criteria) this;
        }

        public Criteria andOndaP2EqualTo(String value) {
            addCriterion("onda_P2 =", value, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2NotEqualTo(String value) {
            addCriterion("onda_P2 <>", value, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2GreaterThan(String value) {
            addCriterion("onda_P2 >", value, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2GreaterThanOrEqualTo(String value) {
            addCriterion("onda_P2 >=", value, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2LessThan(String value) {
            addCriterion("onda_P2 <", value, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2LessThanOrEqualTo(String value) {
            addCriterion("onda_P2 <=", value, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2Like(String value) {
            addCriterion("onda_P2 like", value, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2NotLike(String value) {
            addCriterion("onda_P2 not like", value, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2In(List<String> values) {
            addCriterion("onda_P2 in", values, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2NotIn(List<String> values) {
            addCriterion("onda_P2 not in", values, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2Between(String value1, String value2) {
            addCriterion("onda_P2 between", value1, value2, "ondaP2");
            return (Criteria) this;
        }

        public Criteria andOndaP2NotBetween(String value1, String value2) {
            addCriterion("onda_P2 not between", value1, value2, "ondaP2");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ubicacion
     *
     * @mbg.generated do_not_delete_during_merge Tue Aug 27 21:08:00 CDT 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ubicacion
     *
     * @mbg.generated Tue Aug 27 21:08:00 CDT 2019
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