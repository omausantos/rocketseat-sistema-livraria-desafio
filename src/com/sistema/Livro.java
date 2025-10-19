package com.sistema;

import java.time.LocalDate;

public class Livro {

    private int id;                     // Identificador único do livro
    private String titulo;              // Título do livro
    private Autor autor;                // Autor do livro (objeto do tipo Autor)
    private boolean disponivel;         // Disponibilidade para empréstimo
    private LocalDate dataCadastro;     // Data que o livro foi cadastrado
    private LocalDate dataAtualizacao;  // Data que o livro foi atualizado

    // Construtor
    public Livro(int id, String titulo, Autor autor, boolean disponivel,
                 LocalDate dataCadastro, LocalDate dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDate getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(LocalDate dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    @Override
    public String toString() {
        return String.format(
                "Livro {id=%d, titulo='%s', autor='%s', disponivel=%b, dataCadastro=%5$td/%5$tm/%5$tY, dataAtualizacao=%6$td/%6$tm/%6$tY}",
                id, titulo,
                (autor != null ? autor.getNome() : "Autor não informado"),
                disponivel,
                dataCadastro, dataAtualizacao
        );
    }
}
