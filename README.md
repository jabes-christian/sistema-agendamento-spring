# 📅 Sistema de Agendamento - Spring Boot

![Java](https://img.shields.io/badge/Java-21-blue) ![Spring
Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Docker](https://img.shields.io/badge/Docker-Container-blue)

------------------------------------------------------------------------

## 📌 Sobre o Projeto

O mini **Sistema de Agendamento** é uma API REST desenvolvida com **Spring
Boot**, responsável pelo gerenciamento de agendamentos, permitindo
criar, atualizar, listar e remover registros de forma estruturada.

O projeto foi desenvolvido com foco em boas práticas de desenvolvimento
backend, arquitetura escalável e preparação para ambientes produtivos
utilizando Docker para a criação do Postgres e versionamento de banco de dados com Flyway.

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   Java 21
-   Spring Boot
-   Spring Web
-   Spring Data JPA / Hibernate
-   PostgreSQL
-   Flyway (Database Migration)
-   Docker / Docker Compose
-   Maven
-   Lombok
-   Dbeaver (Interface do Banco de Dados)

------------------------------------------------------------------------

## 🧱 Arquitetura da Aplicação

A aplicação segue arquitetura em camadas:

Client → Controller → Service → Repository → Database

------------------------------------------------------------------------

## 📂 Estrutura do Projeto

    src/
     └── main/
         ├── java/
         │   └── dev/jchristian/SistemaAgendamento
         │        ├── controller
         │        ├── service
         │        ├── repository
         │        ├── model
         │        ├── dto
         │        └── mapper
         └── resources/
             ├── application.properties
             └── db/migration

------------------------------------------------------------------------

## ⚙️ Como Executar o Projeto

### 1. Clonar o repositório

    git clone https://github.com/jabes-christian/sistema-agendamento-spring.git
    cd sistema-agendamento-spring

### 2. Subir o banco PostgreSQL com Docker

    docker-compose up -d

### 3. Executar a aplicação

    ./mvnw spring-boot:run

ou

    mvn spring-boot:run

A aplicação ficará disponível em:

    http://localhost:8080

------------------------------------------------------------------------

## 📡 Endpoints Principais

Método   Endpoint             Descrição
  -------- -------------------- -----------------------
- GET      /agendamentos                 - Listar agendamentos
- GET      /agendamentos/{id}            - Buscar por ID
- POST     /agendamentos                 - Criar agendamento
- PUT      /agendamentos/{id}            - Atualizar agendamento
- PUT   /agendamentos/{id}/cancelar      - Cancelar agendamento
- PUT   /agendamento/{id}/concluir       - Concluir agendamento

------------------------------------------------------------------------

## 📥 Exemplo de Request

``` json
POST /agendamentos

{
    "titulo": "Consulta Médica",
    "descricao": "Consulta médica marcado pela manhã",
    "dataInicio": "2026-02-15T09:30:00",
    "dataFim": "2026-02-15T10:30:00",
    "usuario": "João Silva"
}
```

------------------------------------------------------------------------

## 📤 Exemplo de Response

``` json
{
    "id": 1,
    "titulo": "Consulta Médica",
    "descricao": "Consulta médica marcado pela manhã",
    "dataInicio": "2026-02-15T09:30:00",
    "dataFim": "2026-02-15T10:30:00",
    "status": "AGENDADO",
    "usuario": "João Silva",
    "criadoEm": "2026-02-14T12:00:08.2551233",
    "atualizadoEm": "2026-02-14T12:00:08.2551233"
}
```

------------------------------------------------------------------------

## 🗄️ Banco de Dados

O banco de dados é versionado automaticamente com **Flyway**, garantindo
consistência entre ambientes e controle de alterações no schema.

------------------------------------------------------------------------

## 🎯 Decisões Técnicas

-   Arquitetura em camadas para separação de responsabilidades
-   Uso de DTO + Mapper para desacoplamento entre API e entidade
-   Flyway para versionamento de banco
-   Docker Compose para padronização de ambiente do PostgresSQL
-   JPA/Hibernate para abstração do acesso a dados

------------------------------------------------------------------------

## 🛣️ Roadmap de Evolução

-   Autenticação com Spring Security + JWT
-   Documentação com Swagger/OpenAPI
-   Paginação e filtros avançados
-   Testes unitários e de integração
-   Deploy em cloud (AWS, Render, Railway)

------------------------------------------------------------------------

## 👨‍💻 Autor

**Jabes Christian**\

Github:
https://github.com/jabes-christian

Linkedin:
https://www.linkedin.com/in/jabes-christian/
