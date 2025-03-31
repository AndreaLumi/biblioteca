package com.example.biblioteca.model;
import jakarta.persistence.*;

@Entity
@Table(name = "libri")

public class Biblioteca {
    @Id
    private String isbn;
    private String titolo;
    private String autore;
    private String genere;
    private int anno;
    private boolean disponibilità;

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return titolo; }
    public void setTitle(String titolo) { this.titolo = titolo; }
    public String getAuthor() { return autore; }
    public void setAuthor(String autore) { this.autore = autore; }
    public String getGenre() { return genere; }
    public void setGenre(String genere) { this.genere = genere; }
    public int getYear() { return anno; }
    public void setYear(int anno) { this.anno = anno; }
    public boolean isAvailable() { return disponibilità; }
    public void setAvailable(boolean disponibilità) { this.disponibilità = disponibilità; }
}
