package com.sistema;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner sc = new Scanner(System.in);
        Biblioteca bib = seed(); // cria dados de exemplo

        while (true) {
            System.out.print("Deseja ver a lista de livros disponíveis? (SIM/NÃO): ");
            String resp = sc.nextLine().trim().toUpperCase();

            if ("SIM".equals(resp)) {
                List<Livro> disponiveis = bib.listarLivrosDisponiveis();
                if (disponiveis.isEmpty()) {
                    System.out.println("Nenhum livro disponível no momento.");
                    System.out.println("Até logo!");
                    break;
                }

                System.out.println("\n--- Livros disponíveis ---");
                disponiveis.forEach(l ->
                        System.out.printf("ID: %d | Título: %s | Autor: %s%n",
                                l.getId(), l.getTitulo(),
                                l.getAutor() != null ? l.getAutor().getNome() : "—")
                );

                System.out.print("\nInforme o ID do livro que deseja emprestar: ");
                String idStr = sc.nextLine().trim();
                int livroId;
                try {
                    livroId = Integer.parseInt(idStr);
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido. Encerrando.");
                    System.out.println("Até logo!");
                    break;
                }

                System.out.print("Informe seu nome: ");
                String nomeCliente = sc.nextLine().trim();

                try {
                    Emprestimo emp = bib.emprestarLivro(livroId, nomeCliente);
                    System.out.println("\nEmpréstimo realizado com sucesso!");
                    System.out.println(emp);
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Não foi possível concluir o empréstimo: " + e.getMessage());
                }

                System.out.println("\nAté logo!");
                break; // encerra após a tentativa/conclusão de um empréstimo
            } else if ("NÃO".equals(resp) || "NAO".equals(resp)) {
                System.out.println("Até logo!");
                break;
            } else {
                System.out.println("Resposta inválida. Digite SIM ou NÃO.\n");
            }
        }

        sc.close();
    }

    private static Biblioteca seed() {
        Biblioteca b = new Biblioteca();

        Autor a1 = new Autor(1, "Mauricio Santos", LocalDate.of(1987, 6, 2));
        Autor a2 = new Autor(2, "Machado de Assis", LocalDate.of(1839, 6, 21));

        b.adicionarAutor(a1);
        b.adicionarAutor(a2);

        Livro l1 = new Livro(101, "Java para Iniciantes", a1, true, LocalDate.now(), LocalDate.now());
        Livro l2 = new Livro(102, "Dom Casmurro", a2, true, LocalDate.now(), LocalDate.now());
        Livro l3 = new Livro(103, "Memórias Póstumas de Brás Cubas", a2, false, LocalDate.now(), LocalDate.now()); // indisponível

        b.adicionarLivro(l1);
        b.adicionarLivro(l2);
        b.adicionarLivro(l3);

        return b;
    }
}
