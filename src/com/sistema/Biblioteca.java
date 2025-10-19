package com.sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Biblioteca {

    private final List<Livro> livros = new ArrayList<>();
    private final List<Autor> autores = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private int seqEmprestimoId = 1;

    // ------- Métodos de cadastro (seed / manutenção) -------
    public void adicionarAutor(Autor autor) {
        if (autor != null) autores.add(autor);
    }

    public void adicionarLivro(Livro livro) {
        if (livro != null) livros.add(livro);
    }

    // ------- Consultas -------
    public List<Livro> listarLivrosDisponiveis() {
        return livros.stream()
                .filter(Livro::isDisponivel)
                .collect(Collectors.toList());
    }

    public Optional<Livro> buscarLivroPorId(int id) {
        return livros.stream().filter(l -> l.getId() == id).findFirst();
    }

    // ------- Regras de empréstimo -------
    public Emprestimo emprestarLivro(int livroId, String nomeCliente) {
        Livro livro = buscarLivroPorId(livroId)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado para o id: " + livroId));

        if (!livro.isDisponivel()) {
            throw new IllegalStateException("Livro indisponível para empréstimo.");
        }

        livro.setDisponivel(false);
        Emprestimo emp = new Emprestimo(
                seqEmprestimoId++,
                livro,
                nomeCliente,
                LocalDate.now(),
                null
        );
        emprestimos.add(emp);
        return emp;
    }

    // Getters de leitura (se precisar em relatórios/testes)
    public List<Livro> getLivros() { return livros; }
    public List<Autor> getAutores() { return autores; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
}
