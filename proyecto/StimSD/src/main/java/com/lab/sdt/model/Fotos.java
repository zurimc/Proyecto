package com.lab.sdt.model;

public class Fotos {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fotos.idFoto
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    private Integer idfoto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fotos.idUsuario
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    private Integer idusuario;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fotos.nombre_foto
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    private String nombreFoto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fotos.foto1
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    private byte[] foto1;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fotos.idFoto
     *
     * @return the value of fotos.idFoto
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    public Integer getIdfoto() {
        return idfoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fotos.idFoto
     *
     * @param idfoto the value for fotos.idFoto
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    public void setIdfoto(Integer idfoto) {
        this.idfoto = idfoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fotos.idUsuario
     *
     * @return the value of fotos.idUsuario
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    public Integer getIdusuario() {
        return idusuario;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fotos.idUsuario
     *
     * @param idusuario the value for fotos.idUsuario
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fotos.nombre_foto
     *
     * @return the value of fotos.nombre_foto
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    public String getNombreFoto() {
        return nombreFoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fotos.nombre_foto
     *
     * @param nombreFoto the value for fotos.nombre_foto
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fotos.foto1
     *
     * @return the value of fotos.foto1
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    public byte[] getFoto1() {
        return foto1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fotos.foto1
     *
     * @param foto1 the value for fotos.foto1
     *
     * @mbg.generated Tue Nov 26 16:14:23 CST 2019
     */
    public void setFoto1(byte[] foto1) {
        this.foto1 = foto1;
    }
}