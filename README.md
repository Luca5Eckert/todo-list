# 📝 Todo List - Sistema de Gerenciamento de Tarefas

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java" alt="Java 21"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.3-green?style=for-the-badge&logo=spring" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Maven-3.x-red?style=for-the-badge&logo=apache-maven" alt="Maven"/>
  <img src="https://img.shields.io/badge/H2%20Database-In%20Memory-blue?style=for-the-badge&logo=h2" alt="H2 Database"/>
</p>

## 📖 Sobre o Projeto

Este projeto é um **sistema de gerenciamento de tarefas (Todo List)** desenvolvido em Java, com o objetivo de demonstrar a diferença entre código mal estruturado (**bad-code**) e código bem estruturado seguindo boas práticas de desenvolvimento (**clean-code**).

O projeto foi desenvolvido como parte do curso do **SENAI Centro WEG**, servindo como material educacional para ensinar conceitos de arquitetura de software, Clean Code e boas práticas de desenvolvimento.

## 🏗️ Estrutura do Projeto

O projeto é um **multi-módulo Maven** contendo dois módulos principais:

```
todo-list/
├── pom.xml                    # POM pai (configurações gerais)
├── README.md
├── bad-code/                  # Módulo com código mal estruturado
│   ├── pom.xml
│   └── src/main/java/
│       └── br/com/senai/centroWeg/
│           ├── Main.java      # Aplicação console monolítica
│           └── model/
│               ├── Tarefa.java
│               └── StatusTarefa.java
│
└── clean-code/                # Módulo com código bem estruturado
    ├── pom.xml
    └── src/
        ├── main/
        │   ├── java/
        │   │   └── br/com/senai/centroWeg/
        │   │       ├── Main.java
        │   │       ├── module/
        │   │       │   ├── todo/        # Módulo de Tarefas
        │   │       │   ├── user/        # Módulo de Usuários
        │   │       │   └── streak/      # Módulo de Sequências (gamificação)
        │   │       └── infrastructure/
        │   │           └── repositories/
        │   └── resources/
        │       └── application.properties
        └── test/
```

## 🎯 Módulos

### 📌 Bad Code (Código Ruim)

Uma aplicação console simples que demonstra práticas de programação **não recomendadas**:

- ❌ Código monolítico em uma única classe
- ❌ Lógica de negócio misturada com interface de usuário
- ❌ Sem separação de responsabilidades
- ❌ Sem uso de padrões de projeto
- ❌ Variáveis globais e métodos estáticos

**Funcionalidades:**
- Criar tarefas
- Atualizar status de tarefas (Pendente, Em Andamento, Concluída)
- Excluir tarefas
- Listar tarefas

### ✨ Clean Code (Código Limpo)

Uma API REST completa seguindo boas práticas de desenvolvimento:

- ✅ **Arquitetura em camadas** (Domain, Application, Infrastructure)
- ✅ **Separação de responsabilidades** (Controllers, Services, Repositories)
- ✅ **Padrões de projeto** (Repository Pattern, Command Pattern, Query Pattern)
- ✅ **Injeção de dependências** com Spring
- ✅ **Validação de dados** com Bean Validation
- ✅ **Tratamento de exceções** personalizado
- ✅ **Mapeamento de DTOs**

## 🛠️ Tecnologias Utilizadas

### Clean Code
| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| Java | 21 | Linguagem de programação |
| Spring Boot | 3.2.3 | Framework para criação de aplicações |
| Spring Data JPA | - | Persistência de dados |
| Spring Web | - | API REST |
| Spring Validation | - | Validação de dados |
| H2 Database | - | Banco de dados em memória |
| PostgreSQL | - | Banco de dados relacional (opcional) |
| Lombok | - | Redução de boilerplate |
| Maven | 3.x | Gerenciamento de dependências |

### Bad Code
| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| Java | 21 | Linguagem de programação |
| Maven | 3.x | Gerenciamento de dependências |

## 🚀 Como Executar

### Pré-requisitos

- **Java 21** ou superior instalado
- **Maven 3.x** instalado
- **IDE** de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Executando o Bad Code

```bash
# Clone o repositório
git clone https://github.com/Luca5Eckert/todo-list.git

# Entre no diretório
cd todo-list

# Compile o projeto
mvn clean install

# Execute a aplicação console
cd bad-code
mvn exec:java -Dexec.mainClass="br.com.senai.centroWeg.Main"
```

### Executando o Clean Code

```bash
# Clone o repositório
git clone https://github.com/Luca5Eckert/todo-list.git

# Entre no diretório
cd todo-list

# Compile o projeto
mvn clean install

# Execute a aplicação Spring Boot
cd clean-code
mvn spring-boot:run
```

A aplicação será iniciada em `http://localhost:8080`

## 📚 API REST (Clean Code)

### 👤 Endpoints de Usuários

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/users` | Criar um novo usuário |
| `GET` | `/users` | Listar todos os usuários |
| `GET` | `/users/{id}` | Buscar usuário por ID |
| `PUT` | `/users/{id}` | Atualizar usuário |
| `DELETE` | `/users/{id}` | Excluir usuário |

**Exemplo de criação de usuário:**
```json
POST /users
{
  "name": "João Silva",
  "email": "joao.silva@email.com"
}
```

### ✅ Endpoints de Tarefas (Todo)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/todo` | Criar uma nova tarefa |
| `GET` | `/todo/{id}` | Buscar tarefa por ID |
| `GET` | `/todo/users/{userId}` | Listar tarefas de um usuário |
| `PUT` | `/todo/{id}` | Atualizar status da tarefa |
| `DELETE` | `/todo` | Excluir tarefa |

**Exemplo de criação de tarefa:**
```json
POST /todo
{
  "title": "Implementar login",
  "description": "Implementar sistema de autenticação JWT",
  "authorId": 1,
  "statusTodo": "PENDING"
}
```

**Status disponíveis:**
- `PENDING` - Pendente
- `IN_PROGRESS` - Em Andamento
- `COMPLETED` - Concluída

### 🔥 Endpoints de Streaks (Sequências)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/streaks/{id}` | Buscar streak por ID |
| `GET` | `/streaks/users/{userId}` | Listar todas as streaks de um usuário |
| `GET` | `/streaks/users/{userId}/active` | Buscar streak ativa do usuário |
| `GET` | `/streaks/users/{userId}/analytics` | Obter análises de streaks do usuário |

## 💾 Banco de Dados

### Console H2 (Desenvolvimento)

O projeto utiliza o **H2 Database** em memória para desenvolvimento. Você pode acessar o console em:

```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (deixe em branco)
```

### PostgreSQL (Produção)

Para produção, o projeto está configurado para suportar PostgreSQL. Altere as configurações em `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

## 🧪 Testes

```bash
# Executar todos os testes
mvn test

# Executar testes com relatório
mvn test -Dmaven.test.failure.ignore=true
```

## 📁 Arquitetura Clean Code

O módulo **clean-code** segue uma arquitetura em camadas inspirada no Clean Architecture:

```
module/
├── domain/              # Camada de Domínio (regras de negócio)
│   ├── model/           # Entidades do domínio
│   ├── repository/      # Interfaces de repositório (portas)
│   ├── service/         # Serviços de domínio
│   ├── command/         # Comandos (operações de escrita)
│   ├── query/           # Queries (operações de leitura)
│   ├── exception/       # Exceções de domínio
│   └── port/            # Interfaces para serviços externos
│
├── application/         # Camada de Aplicação (casos de uso)
│   ├── controller/      # Controllers REST
│   ├── dto/             # Data Transfer Objects
│   └── mapper/          # Mapeadores DTO <-> Domain
│
└── infrastructure/      # Camada de Infraestrutura
    └── repositories/    # Implementações dos repositórios (adaptadores)
```

### Padrões Utilizados

- **CQRS (Command Query Responsibility Segregation)**: Separação entre comandos (escrita) e queries (leitura)
- **Repository Pattern**: Abstração da camada de persistência
- **Dependency Injection**: Inversão de dependências via Spring
- **DTO Pattern**: Transferência de dados entre camadas

## 👨‍💻 Autor

Desenvolvido como projeto educacional para o **SENAI Centro WEG**.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

<p align="center">
  Feito com ❤️ para fins educacionais
</p>
