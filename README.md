# 🛒 CRUD de Produtos

## 📦 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de praticar e compreender os conceitos básicos de um **CRUD (Create, Read, Update e Delete)** utilizando Java e conexão com banco de dados.

O sistema simula o gerenciamento de produtos de uma loja, permitindo cadastrar, listar, atualizar e excluir produtos armazenados em um banco de dados MySQL.

O projeto foi desenvolvido como uma atividade de aprendizado sobre o funcionamento de uma aplicação Java conectada a um banco de dados através de JDBC.

## ⚙️ Funcionalidades

O sistema possui as seguintes operações:

* **Create (Cadastrar):** permite cadastrar um novo produto no banco de dados.
* **Read (Listar):** permite consultar e listar os produtos cadastrados.
* **Update (Atualizar):** permite alterar o nome e o preço de um produto utilizando seu ID.
* **Delete (Excluir):** permite excluir um produto utilizando seu ID.

## 🛠️ Tecnologias utilizadas

* **Java**
* **JDBC**
* **MySQL**
* **Maven**
* **MySQL Connector/J**
* **IntelliJ IDEA** ou **Visual Studio Code**

## 📁 Estrutura do projeto

O projeto foi organizado seguindo uma separação simples de responsabilidades:

```text
src/
└── main/
    └── java/
        ├── connection/
        │   └── Conexao.java
        │
        ├── dao/
        │   └── ProdutoDAO.java
        │
        ├── model/
        │   └── Produto.java
        │
        ├── Main.java
        │
        └── pom.xml
```

### Model

A pasta `model` contém as classes responsáveis por representar os dados da aplicação.

A classe `Produto` representa um produto, contendo:

* ID
* Nome
* Preço

### Connection

A pasta `connection` contém a classe responsável por realizar a conexão entre a aplicação Java e o banco de dados MySQL.

A configuração da conexão está localizada no arquivo:

```text
src/main/java/connection/Conexao.java
```

### DAO

A pasta `dao` contém a classe `ProdutoDAO`, responsável por executar as operações SQL relacionadas aos produtos.

Nela estão implementadas as operações de:

* Cadastro
* Listagem
* Atualização
* Exclusão

### Main

A classe `Main` contém a execução principal do programa e apresenta um menu no terminal para que o usuário escolha qual operação deseja realizar.

## 📋 Pré-requisitos

Para executar o projeto, é necessário ter instalado:

* Java
* Maven
* MySQL

O projeto pode ser aberto tanto no **IntelliJ IDEA** quanto no **Visual Studio Code**.

No Visual Studio Code, é necessário instalar as extensões relacionadas ao desenvolvimento Java.

## 🗄️ Configuração do banco de dados

O projeto utiliza um banco de dados MySQL chamado `loja`.

É necessário criar o banco e a tabela utilizada pelo sistema antes de executar a aplicação.

Exemplo:

```sql
CREATE DATABASE loja;

USE loja;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    preco DECIMAL(10, 2)
);
```

## 🔌 Configuração da conexão

Antes de executar o projeto, é necessário configurar os dados de acesso ao MySQL no arquivo:

```text
src/main/java/connection/Conexao.java
```

A conexão possui as seguintes configurações:

```java
private static final String URL = "jdbc:mysql://localhost:3306/loja";
private static final String USUARIO = "root";
private static final String SENHA = "";
```

Caso o banco de dados, usuário ou senha sejam diferentes, altere essas informações de acordo com a configuração do seu MySQL ou outro banco de dados compatível.

## ▶️ Executando o projeto

Após configurar o banco de dados e a conexão, o projeto pode ser executado pela classe:

```text
Main.java
```

Ao iniciar o programa, será apresentado um menu no terminal:

```text
==============================
 CRUD DE PRODUTOS
==============================
1 - Cadastrar Produto
2 - Listar Produtos
3 - Atualizar Produto
4 - Excluir Produto
5 - Sair
```

Basta selecionar a opção desejada e seguir as instruções apresentadas no terminal.

## 📦 Maven

O projeto utiliza Maven para gerenciamento da dependência do MySQL Connector/J.

A dependência utilizada é:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.3.0</version>
</dependency>
```

## 🎯 Objetivo de aprendizado

O principal objetivo deste projeto foi compreender, na prática:

* O funcionamento de um CRUD.
* A comunicação entre Java e MySQL.
* O uso de JDBC.
* A execução de comandos SQL através do Java.
* A utilização do padrão DAO para separar as operações de acesso ao banco.
* A organização de um projeto Java em diferentes responsabilidades.
* O gerenciamento de dependências utilizando Maven.
