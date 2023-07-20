package com.ivoy.backend.models;

import jakarta.persistence.*;


@Entity
@Table(name = "usuarios")
public class Usuario {
    @Column(name="id_usuario")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="email")
    private String email;
    @Column(name="calle")
    private String calle;
    @Column(name="num_exterior")
    private int num_exterior;
    @Column(name="num_interior")
    private int num_interior;
    @Column(name="codigo_postal")
    private int codigo_postal;
    @Column(name="delegacion")
    private String delegacion;
    @Column(name="password")
    private String password;


    public String getPassword(){
        return this.password;
    }
    public void setPassword(String pswrd){
        this.password=pswrd;
    }
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNum_exterior() {
        return num_exterior;
    }

    public void setNum_exterior(int num_exterior) {
        this.num_exterior = num_exterior;
    }

    public int getNum_interior() {
        return num_interior;
    }

    public void setNum_interior(int num_interior) {
        this.num_interior = num_interior;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }
}
