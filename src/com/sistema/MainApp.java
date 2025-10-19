package com.sistema;

import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {
        Autor autor = new Autor(545121, "Mauricio Santos", LocalDate.of(1987, 6, 2));

        Livro livro = new Livro(
                101,
                "Java para Iniciantes",
                autor,
                true,
                LocalDate.now(),
                LocalDate.now()
        );

        System.out.println(autor);
        System.out.println(livro);
    }
}
