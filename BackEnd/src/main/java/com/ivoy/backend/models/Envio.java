package com.ivoy.backend.models;

import jakarta.persistence.*;
import org.yaml.snakeyaml.tokens.ValueToken;

import java.util.Date;

@Entity
@Table(name="envios")
public class Envio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="alto")
    private int alto;
    @Column(name="ancho")
    private int ancho;
    @Column(name="profundo")
    private int profundo;
    @Column(name="peso")
    private int peso;
    @Column(name="calle_recoleccion")
    private String calle_recoleccion;
    @Column(name="num_exterior_recoleccion")
    private int num_exterior_recoleccion;
    @Column(name="num_interior_recoleccion")
    private int num_interior_recoleccion;
    @Column(name="codigo_postal_recoleccion")
    private int codigo_postal_recoleccion;
    @Column(name="delegacion_recoleccion")
    private String delegacion_recoleccion;
    @Column(name="calle_entrega")
    private String calle_entrega;
    @Column(name="num_exterior_entrega")
    private int num_exterior_entrega;
    @Column(name="num_interior_entrega")
    private int num_interior_entrega;
    @Column(name="codigo_postal_entrega")
    private int codigo_postal_entrega;
    @Column(name="delegacion_entrega")
    private String delegacion_entrega;
    @Column(name="fecha")
    private Date fecha;
    @Column(name="costo")
    private float costo;
    @Column(name="nombre_entrega")
    private String nombre_entrega;
    @Column(name="id_usuario")
    private int id_usuario;
    @Column(name="id_repartidor")
    private int id_repartidor;
    @Column(name="entregado")
    private int entregado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getProfundo() {
        return profundo;
    }

    public void setProfundo(int profundo) {
        this.profundo = profundo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getCalle_recoleccion() {
        return calle_recoleccion;
    }

    public void setCalle_recoleccion(String calle_recoleccion) {
        this.calle_recoleccion = calle_recoleccion;
    }

    public int getNum_exterior_recoleccion() {
        return num_exterior_recoleccion;
    }

    public void setNum_exterior_recoleccion(int num_exterior_recoleccion) {
        this.num_exterior_recoleccion = num_exterior_recoleccion;
    }

    public int getNum_interior_recoleccion() {
        return num_interior_recoleccion;
    }

    public void setNum_interior_recoleccion(int num_interior_recoleccion) {
        this.num_interior_recoleccion = num_interior_recoleccion;
    }

    public int getCodigo_postal_recoleccion() {
        return codigo_postal_recoleccion;
    }

    public void setCodigo_postal_recoleccion(int codigo_postal_recoleccion) {
        this.codigo_postal_recoleccion = codigo_postal_recoleccion;
    }

    public String getDelegacion_recoleccion() {
        return delegacion_recoleccion;
    }

    public void setDelegacion_recoleccion(String delegacion_recoleccion) {
        this.delegacion_recoleccion = delegacion_recoleccion;
    }

    public String getCalle_entrega() {
        return calle_entrega;
    }

    public void setCalle_entrega(String calle_entrega) {
        this.calle_entrega = calle_entrega;
    }

    public int getNum_exterior_entrega() {
        return num_exterior_entrega;
    }

    public void setNum_exterior_entrega(int num_exterior_entrega) {
        this.num_exterior_entrega = num_exterior_entrega;
    }

    public int getNum_interior_entrega() {
        return num_interior_entrega;
    }

    public void setNum_interior_entrega(int num_interior_entrega) {
        this.num_interior_entrega = num_interior_entrega;
    }

    public int getCodigo_postal_entrega() {
        return codigo_postal_entrega;
    }

    public void setCodigo_postal_entrega(int codigo_postal_entrega) {
        this.codigo_postal_entrega = codigo_postal_entrega;
    }

    public String getDelegacion_entrega() {
        return delegacion_entrega;
    }

    public void setDelegacion_entrega(String delegacion_entrega) {
        this.delegacion_entrega = delegacion_entrega;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getNombre_entrega() {
        return nombre_entrega;
    }

    public void setNombre_entrega(String nombre_entrega) {
        this.nombre_entrega = nombre_entrega;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(int id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public int getEntregado() {
        return entregado;
    }

    public void setEntregado(int entregado) {
        this.entregado = entregado;
    }
}
