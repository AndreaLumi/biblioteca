package com.example.biblioteca.repository;

import com.example.biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, String> {

    // Metodo per trovare libri per genere
    List<Biblioteca> findByGenre(String genre);

    // Metodo per trovare libri per anno
    List<Biblioteca> findByYear(int year);

    // Metodo per trovare libri per disponibilità
    List<Biblioteca> findByAvailable(boolean available);
}
