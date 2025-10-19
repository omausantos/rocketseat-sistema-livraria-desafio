# 📚 Desafio: Sistema de Livraria – Java Essentials (Rocketseat)

Este projeto foi desenvolvido como parte do **Módulo Java Essentials** da [Rocketseat](https://app.rocketseat.com.br/projects/desafio-sistema-de-livraria?module_slug=sistema-de-livraria).

O desafio consiste em criar um **sistema de console** para gerenciar o empréstimo de livros de uma biblioteca.

---

## 🚀 Objetivo
- Gerenciar livros, autores e empréstimos.  
- Permitir ao usuário ver os livros disponíveis.  
- Realizar o empréstimo de um livro, registrando o cliente e marcando o livro como indisponível.  

---

## 🏗 Estrutura do Projeto

- **Autor** → Representa o autor de um livro.  
- **Livro** → Representa um livro, com título, autor, disponibilidade e datas de cadastro/atualização.  
- **Emprestimo** → Representa o registro de um empréstimo (livro, cliente, data de empréstimo e devolução).  
- **Biblioteca** → Centraliza as listas de autores, livros e empréstimos. Implementa as regras de negócio.  
- **MainApp** → Classe principal, responsável por interagir com o usuário via console.  

---

## ⚙️ Como funciona

1. O programa pergunta se o usuário deseja ver a lista de livros disponíveis.  
2. Se responder **SIM**:  
   - Mostra todos os livros que **não foram emprestados**.  
   - O usuário escolhe o livro pelo **ID**, informa seu nome, e o empréstimo é registrado.  
   - O livro é marcado como **indisponível**.  
   - O sistema exibe mensagem de sucesso e encerra.  
3. Se responder **NÃO**:  
   - O programa encerra imediatamente com uma mensagem de despedida.  

---

## ▶️ Execução

### 1. Compilação
Na raiz do projeto, rode:
```bash
javac com/sistema/*.java
```

### 2. Execução
```bash
java com.sistema.MainApp
```

---

## 💻 Exemplo de uso

```
Deseja ver a lista de livros disponíveis? (SIM/NÃO): SIM

--- Livros disponíveis ---
ID: 101 | Título: Java para Iniciantes | Autor: Mauricio Santos
ID: 102 | Título: Dom Casmurro | Autor: Machado de Assis

Informe o ID do livro que deseja emprestar: 101
Informe seu nome: João Silva

Empréstimo realizado com sucesso!
Empréstimo {id=1, livro='Java para Iniciantes', cliente='João Silva', dataEmprestimo=19/10/2025, dataDevolucao=Não devolvido}

Até logo!
```

---

## 🛠 Tecnologias
- Java 21+  
- Programação Orientada a Objetos  
- Entrada e saída no console com `Scanner`  
- Estruturas de dados (`ArrayList`)  

---

## 🌱 Melhorias futuras
- Implementar devolução de livros.  
- Cadastrar novos autores e livros via console.  
- Criar menu interativo com múltiplas opções.  
- Persistir os dados em arquivo ou banco de dados.  
- Evoluir para interface gráfica ou API REST.  

---

Desafio disponível em: [Rocketseat – Sistema de Livraria](https://app.rocketseat.com.br/projects/desafio-sistema-de-livraria?module_slug=sistema-de-livraria)
