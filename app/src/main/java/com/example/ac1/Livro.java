package com.example.ac1;

public class Livro {

    private String livro;
    private String autor;
    private boolean lido;

    public Livro(String livro, String autor, boolean lido) {
        this.livro = livro;
        this.autor = autor;
        this.lido = lido;
    }

    // Getters for the properties
    public String getLivro() { return livro; }
    public String getAutor() { return autor; }
    public boolean lido() { return lido; }

    public void add(Livro novoLivro) {
    }
}