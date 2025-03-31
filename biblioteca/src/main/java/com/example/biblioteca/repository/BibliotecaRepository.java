package com.example.biblioteca.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; 
import com.example.biblioteca.model.*;

public class BibliotecaRepository {
    interface BookRepository extends JpaRepository<BibliotecaRepository, String> {
        List<BibliotecaRepository> findByGenere(String genere);
        List<BibliotecaRepository> findByAnno(int anno);
        List<BibliotecaRepository> findByDisponibilità(boolean disponibilità);
    }
}
