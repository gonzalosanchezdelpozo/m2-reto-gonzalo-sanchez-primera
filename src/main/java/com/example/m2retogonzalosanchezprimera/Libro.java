package com.example.m2retogonzalosanchezprimera;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Libro {

    // 1. atributos encapsulados (private)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Integer numero_paginas;
    private String editorial;
    private String encuadernacion;
    private String isbn;
    private Integer anio;
    private String plaza_edicion;

    // 2. constructores

    public Libro() {
    }

    public Libro(Long id, String titulo, String autor, Integer numero_paginas, String editorial, String encuadernacion, String isbn, Integer anio, String plaza_edicion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numero_paginas = numero_paginas;
        this.editorial = editorial;
        this.encuadernacion = encuadernacion;
        this.isbn = isbn;
        this.anio = anio;
        this.plaza_edicion = plaza_edicion;
    }

    // 3. Métodos getter y setter

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getNumero_paginas() {
        return numero_paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getEncuadernacion() {
        return encuadernacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getPlaza_edicion() {
        return plaza_edicion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumero_paginas(Integer numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setEncuadernacion(String encuadernacion) {
        this.encuadernacion = encuadernacion;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void setPlaza_edicion(String plaza_edicion) {
        this.plaza_edicion = plaza_edicion;
    }

    // 4. toString()

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + titulo + '\'' +
                ", numero_paginas=" + numero_paginas +
                ", editorial='" + editorial + '\'' +
                ", encuadernacion='" + encuadernacion + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anio=" + anio +
                ", plaza_edicion='" + plaza_edicion + '\'' +
                '}';
    }
}
