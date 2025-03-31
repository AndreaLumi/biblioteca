package com.example.biblioteca.repository;

import com.example.biblioteca.model.Biblioteca;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public class BibliotecaRepository {
interface BibliotecaRepository extends JpaRepository<BibliotecaRepository,String> {
    // trova libri per genere
    List<libri> findBygenere(String genere);
    // trova libri per anno
    List<libri> findByAnno(int anno);
    //trova libri per disponibilità
    List<libri>findByDisponibilità(boolean disponibile)

}
}