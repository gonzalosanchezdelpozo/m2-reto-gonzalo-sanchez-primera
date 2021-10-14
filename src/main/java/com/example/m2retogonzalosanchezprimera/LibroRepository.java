package com.example.m2retogonzalosanchezprimera;
import com.example.m2retogonzalosanchezprimera.Libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {


    List<Libro> findByEditorial(String editorial);

    List<Libro> findByEditorialAndAutor(String editorial,  String autor);

    List<Libro> findByNumero_PaginasLessThan(Integer numero_paginas);

}
