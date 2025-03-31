package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.biblioteca.model.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, String> {
    List<Biblioteca> findByGenere(String genere);
    List<Biblioteca> findByAnno(int anno);
    List<Biblioteca> findByDisponibilità(boolean disponibilità);
}
