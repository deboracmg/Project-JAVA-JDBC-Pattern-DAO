# Projeto JAVA, JDBC e JOptionPane 🖥️💾

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

Projeto de acesso a banco de dados utilizando Java e JDBC, aplicando o padrão DAO, com interface gráfica simples baseada em JOptionPane.

---

## 📌 Visão Geral

Este projeto demonstra:
- Conexão com banco de dados via JDBC 🔗
- Aplicação do padrão DAO (Data Access Object) 📂
- Interface gráfica simples com JOptionPane 🖼️

Ideal para estudos sobre arquitetura de software, persistência de dados e CRUD em Java.

---

## ✨ Funcionalidades

- Criar registros (Create) ➕
- Consultar registros (Read) 🔍
- Atualizar registros (Update) ✏️
- Remover registros (Delete) ❌
- Interação com usuário via JOptionPane 💬

---

## 🛠️ Tecnologias

- Java (versão: 21) ☕
- JDBC 🗄️
- Banco de dados (MySQL) 🐬
- Swing/JOptionPane 🖼️

---

## 📂 Estrutura do Projeto
```
Project/
│
├── src/
│   ├── application/      # GUI e classe principal
│   ├── db/               # Classe de conexão ao banco
│   ├── model/dao/        # Interfaces e implementações DAO
│   ├── model/entities/   # Entidades do sistema
```

---

## ⚙️ Requisitos

- Java instalado (>= 21) ☕
- Driver JDBC do banco configurado 🔌
- Banco de dados criado com tabelas necessárias 🗄️
- IDE (Eclipse, IntelliJ, NetBeans) ou terminal com javac/java 💻

---

## ▶️ Como Rodar

1. Clone o repositório:
```bash
git clone https://github.com/deboracmg/Project-JAVA-JDBC-Pattern-DAO.git
```
2. Abra o projeto na sua IDE ou compile via terminal.
3. Configure a conexão com o banco (usuário, senha e URL JDBC).
4. Adicione o driver JDBC ao classpath.
5. Execute a classe principal:
```bash
Main.java
```
6. Use a interface via JOptionPane para realizar operações CRUD.

---

## 📄 Licença

Este projeto está sob a licença **MIT License**.

---


Desenvolvido por [@deboracmg](https://github.com/deboracmg)  
