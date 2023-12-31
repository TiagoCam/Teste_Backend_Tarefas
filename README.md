<h1 align="center">
	<img src="https://i.imgur.com/USFFl6m.png"  alt="Logo"  width="200"><br><br>
    Gerenciador de Tarefas
</h1>

<div>
    <p align="center">
    <a href="https://www.linkedin.com/in/tiago-m-03443594/" target="_blank">
        <img src="https://img.shields.io/static/v1?label=Author&message=Tiago Moraes&color=00ba6d&style=for-the-badge&logo=LinkedIn" alt="Author: Tiago">
    </a>
    <a href="#">
		<img  src="https://img.shields.io/static/v1?label=Language&message=Java&color=red&style=for-the-badge&logo=Java"  alt="Language: Java">
	</a>
    </p>
</div>

## Table of Contents

<p align="center">
 <a href="#about">About</a> •
 <a href="#features">Features</a> •
 <a href="#technologies">Technologies</a> • 
 <a href="#documentation">Documentation</a> •
 <a href="#installation ">Installation </a> •
 <a href="#getting-started">Get Started</a> •
 <a href="#postgresql">PostgreSQL</a>
 
</p>

<br>

## 📌About

<div>
    <p align="center">
    API-REST de gerenciamento de tarefas!
    </p>
</div>

<br>

## 🚀Features

- Criar, Editar e Apagar (Pessoa, Tarefa e Departamento)
- Alocar uma pessoa na tarefa que tenha o mesmo departamento (put/tarefas/alocar/{id})
- Finalizar a tarefa (put/tarefas/finalizar/{id})
- Listar pessoas trazendo nome, departamento, total horas gastas nas tarefas.(get/pessoas)
- Buscar pessoas por nome e retorna média de horas gastas por tarefa. (get/pessoas/gastos)
- Listar departamento e quantidade de pessoas e tarefas (get/departamentos)

<br>

## 🌐Technologies

- Java 8
- JPA
- Maven
- Spring Boot
- Swagger
- PostgreSQL
- Postman

<br>

## 📃Documentation

- Link Documentação Swagger: https://tasks-documentacao.netlify.app/

<br>

## 📕Installation
**Você já deve ter instalado os seguintes programas**
- Maven <a href="https://maven.apache.org/install.html">(Veja como você instala o Maven)</a>

**Recomendações**
- É recomendável que você tenha instalado o Google Chrome ou Edge
- Eu recomendo usar o Intellij como IDE de desenvolvimento

**A instalação e inicialização são 4 etapas!**
1. Clone este repositório
2. Entre na pasta descompactada
3. Build com Maven

### 1. Clone this repository
```
git clone https://github.com/TiagoCam/Teste_Backend_Tarefas.git
```
---

### 2. Acesse a pasta descompactada pelo terminal
```
cd <caminho da pasta>
```
---

### 3. Build o projeto com Maven - (Pasta raiz)
```
mvn clean install
```
```
mvn install
```
- Observações:
    - mvn ➡️ Você está chamando o executável, o que significa que você precisa do Maven instalado em sua máquina.

    - clean ➡️ Excluirá todos os arquivos e recursos Java .class compilados anteriormente (como .properties) no projeto, sua compilação começará do zero.

    - install ➡️ Compilar, testar e empacotar seu projeto Java e até mesmo instalar/copiar seu arquivo .jar/.war construído em seu repositório Maven local. <a href="https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html"> (Veja o Ciclo de vida do Maven )</a>

---

<br>

## 🎮Getting Started
- Abra o navegador e entre no seguinte link: http://localhost:8080
    - O link acima irá abrir o Swagger do projeto em questão!

<br>

## 📁PostgreSQL
**Para utilizar o banco de dados siga os seguintes passos**

### 1. NO arquivo application.properties coloque a URL do Banco de dados 📁PostgreSQL
```
spring.datasource.url = jdbc:postgresql://localhost:5432/Nome_do_DB
spring.datasource.username = postgres
spring.datasource.password = Sua_senha
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
spring.jpa.properties.hibernate.jdbc.lob.non.contextual_creation = true
```


