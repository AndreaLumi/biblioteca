package com.example.biblioteca.controller;

import com.example.biblioteca.model.Biblioteca;
import com.example.biblioteca.repository.BibliotecaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libri")
public class BibliotecaController {

    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    public BibliotecaController(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    @PostMapping
    public Biblioteca addLibro(@RequestBody Biblioteca libro) {
        return bibliotecaRepository.save(libro);
    }

    @GetMapping
    public List<Biblioteca> getAllLibri() {
        return bibliotecaRepository.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Biblioteca> getLibroById(@PathVariable String isbn) {
        Optional<Biblioteca> libro = bibliotecaRepository.findById(isbn);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Biblioteca> updateLibro(@PathVariable String isbn, @RequestBody Biblioteca libroDetails) {
        return bibliotecaRepository.findById(isbn).map(libro -> {
            libro.setTitle(libroDetails.getTitle());
            libro.setAuthor(libroDetails.getAuthor());
            libro.setGenre(libroDetails.getGenre());
            libro.setYear(libroDetails.getYear());
            libro.setAvailable(libroDetails.isAvailable());
            return ResponseEntity.ok(bibliotecaRepository.save(libro));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteLibro(@PathVariable String isbn) {
        if (bibliotecaRepository.existsById(isbn)) {
            bibliotecaRepository.deleteById(isbn);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/genre/{genre}")
    public List<Biblioteca> getLibriByGenre(@PathVariable String genre) {
        return bibliotecaRepository.findByGenre(genre);
    }

    @GetMapping("/year/{year}")
    public List<Biblioteca> getLibriByYear(@PathVariable int year) {
        return bibliotecaRepository.findByYear(year);
    }

    @GetMapping("/available/{available}")
    public List<Biblioteca> getLibriByAvailable(@PathVariable boolean available) {
        return bibliotecaRepository.findByAvailable(available);
    }

    @PutMapping("/{isbn}/prenota")
    public ResponseEntity<Biblioteca> prenotaLibro(@PathVariable String isbn) {
        return bibliotecaRepository.findById(isbn).map(libro -> {
            libro.setAvailable(false);
            return ResponseEntity.ok(bibliotecaRepository.save(libro));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
