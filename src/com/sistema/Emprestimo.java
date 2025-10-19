package com.sistema;

import java.time.LocalDate;

/**
 * Representa um empréstimo de livro em um sistema de biblioteca.
 * Contém informações sobre o livro emprestado, o cliente,
 * a data do empréstimo e a data de devolução.
 */
public class Emprestimo {

    /** Identificador único do empréstimo. */
    private int id;

    /** Livro que foi emprestado. */
    private Livro livro;

    /** Nome do cliente que pegou o livro emprestado. */
    private String nomeCliente;

    /** Data em que o empréstimo foi realizado. */
    private LocalDate dataEmprestimo;

    /**
     * Data em que o livro foi devolvido.
     * Pode ser {@code null} caso o livro ainda não tenha sido devolvido.
     */
    private LocalDate dataDevolucao;

    /**
     * Construtor da classe Emprestimo.
     *
     * @param id identificador único do empréstimo
     * @param livro livro emprestado
     * @param nomeCliente nome do cliente que pegou o livro
     * @param dataEmprestimo data do empréstimo
     * @param dataDevolucao data da devolução (pode ser {@code null})
     */
    public Emprestimo(int id, Livro livro, String nomeCliente,
                      LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.livro = livro;
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    /** @return identificador único do empréstimo */
    public int getId() { return id; }

    /** @param id novo identificador do empréstimo */
    public void setId(int id) { this.id = id; }

    /** @return livro emprestado */
    public Livro getLivro() { return livro; }

    /** @param livro livro emprestado */
    public void setLivro(Livro livro) { this.livro = livro; }

    /** @return nome do cliente que pegou o livro */
    public String getNomeCliente() { return nomeCliente; }

    /** @param nomeCliente nome do cliente que pegou o livro */
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    /** @return data em que o empréstimo foi realizado */
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }

    /** @param dataEmprestimo data do empréstimo */
    public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    /**
     * @return data de devolução ou {@code null} se ainda não devolvido
     */
    public LocalDate getDataDevolucao() { return dataDevolucao; }

    /** @param dataDevolucao data da devolução */
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    /**
     * Retorna uma representação textual do empréstimo.
     * A data é formatada no padrão brasileiro (dd/MM/yyyy).
     *
     * @return string com os dados do empréstimo
     */
    @Override
    public String toString() {
        return String.format(
                "Empréstimo {id=%d, livro='%s', cliente='%s', dataEmprestimo=%4$td/%4$tm/%4$tY, dataDevolucao=%5$s}",
                id,
                (livro != null ? livro.getTitulo() : "Livro não informado"),
                nomeCliente,
                dataEmprestimo,
                (dataDevolucao != null ? String.format("%1$td/%1$tm/%1$tY", dataDevolucao) : "Não devolvido")
        );
    }
}
