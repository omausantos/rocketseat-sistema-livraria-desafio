package com.sistema;

import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {
        Autor autor = new Autor(545121, "Mauricio Santos", LocalDate.of(1987, 6, 2));
        System.out.println(autor);
    }
}
