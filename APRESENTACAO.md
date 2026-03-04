# 📋 Pitch - Sistema de Lista de Tarefas (Todo-List)

## 🎯 Roteiro da Apresentação (10 minutos)

---

## 1️⃣ O PROBLEMA - Código Ruim (3 minutos)

### Qual princípio estava sendo mais ferido?

O código na pasta `bad-code/` viola **múltiplos princípios SOLID**, mas o principal é:

### 🚫 SRP - Single Responsibility Principle (Princípio da Responsabilidade Única)

No arquivo `Main.java` do código ruim, **UMA ÚNICA CLASSE** é responsável por:

```
❌ Interface do usuário (menu console)
❌ Lógica de negócios (criar, atualizar, excluir tarefas)
❌ Persistência de dados (armazenamento em ArrayList)
❌ Controle de fluxo da aplicação
❌ Validação de entrada do usuário
```

**Exemplo no código:**
```java
// Tudo em uma única classe Main.java (150+ linhas):
public class Main {
    public static final List<Tarefa> tarefas = new ArrayList<>();  // ❌ Dados
    public static int id = 0;                                       // ❌ Estado global
    
    public static void main(String[] args) { ... }                  // ❌ Controle
    public static boolean Iniciar() { ... }                         // ❌ UI + Lógica
    public static void alterarStatus(...) { ... }                   // ❌ Negócio
    public static void excluirTarefa(...) { ... }                   // ❌ Negócio
    public static void criarTarefa(...) { ... }                     // ❌ Negócio
    public static void verTarefas() { ... }                         // ❌ Negócio
}
```

### 🚫 Outros Princípios Violados:

| Princípio | Violação |
|-----------|----------|
| **OCP** (Open/Closed) | Para adicionar novos status, é preciso modificar o switch case |
| **DIP** (Dependency Inversion) | Alto acoplamento - tudo depende de implementações concretas |
| **Alta Coesão** | Uma classe faz tudo - baixíssima coesão |
| **Baixo Acoplamento** | Impossível trocar a camada de dados ou UI sem reescrever tudo |

### 📉 Consequências do Código Ruim:
- Impossível testar unitariamente
- Difícil de manter e evoluir
- Impossível reutilizar componentes
- Alto risco de introduzir bugs ao fazer alterações

---

## 2️⃣ A SOLUÇÃO - Arquitetura em Camadas (4 minutos)

### Como a arquitetura em camadas resolveu o acoplamento?

O código na pasta `clean-code/` implementa uma **Arquitetura em Camadas** seguindo DDD (Domain-Driven Design):

### 📁 Estrutura de Pastas:

```
clean-code/
└── src/main/java/br/com/senai/centroWeg/
    ├── module/
    │   ├── todo/
    │   │   ├── domain/           ← 🎯 CAMADA DE DOMÍNIO
    │   │   │   ├── model/        (Todo, StatusTodo)
    │   │   │   ├── service/      (TodoService)
    │   │   │   ├── repository/   (TodoRepository - Interface)
    │   │   │   ├── command/      (TodoCreateCommand, UpdateTodoCommand)
    │   │   │   ├── query/        (GetTodoByIdQuery, GetTodoByUserQuery)
    │   │   │   ├── exception/    (TodoNotFoundException, etc.)
    │   │   │   └── port/         (StreakUpdater - Interface)
    │   │   └── application/      ← 🌐 CAMADA DE APLICAÇÃO
    │   │       ├── controller/   (TodoController - REST API)
    │   │       ├── dto/          (TodoCreateRequest, TodoResponse)
    │   │       └── mapper/       (TodoMapper)
    │   ├── user/                 ← Módulo de Usuários (mesma estrutura)
    │   └── streak/               ← Módulo de Streaks (mesma estrutura)
    └── infrastructure/           ← 🔧 CAMADA DE INFRAESTRUTURA
        └── repositories/
            ├── todo/             (JpaTodoRepository, TodoRepositoryAdapter)
            ├── user/             (JpaUserRepository, UserRepositoryAdapter)
            └── streak/           (JpaStreakRepository, StreakRepositoryAdapter)
```

### ✅ Como cada problema foi resolvido:

| Problema Anterior | Solução com Camadas |
|-------------------|---------------------|
| Tudo em uma classe | Separação em Controller, Service, Repository |
| Dados em ArrayList | Interfaces de Repository + JPA para persistência |
| UI misturada com lógica | Controller (API REST) separado do Service |
| Estado global | Injeção de dependência com Spring |
| Impossível testar | Interfaces permitem mocks para testes |

### ✅ Princípios SOLID Aplicados:

**SRP (Single Responsibility):**
```java
TodoController   → Apenas recebe requisições HTTP
TodoService      → Apenas lógica de negócios
TodoRepository   → Apenas acesso a dados
Todo             → Apenas representa o modelo
```

**OCP (Open/Closed):**
```java
// Interface permite extensão sem modificação
public interface TodoRepository {
    Todo save(Todo todo);
    List<Todo> findAll();
    Optional<Todo> findById(int Id);
}
// Posso criar NoSqlTodoRepository sem alterar o código existente
```

**DIP (Dependency Inversion):**
```java
// Service depende de abstração, não implementação
public class TodoService {
    private final TodoRepository todoRepository;  // Interface!
    private final StreakUpdater streakUpdater;    // Interface!
}
```

**Padrão Port/Adapter:**
```java
// Port (Interface no domínio)
public interface StreakUpdater {
    void update(int userId);
}

// Adapter (Implementação na infraestrutura)
public class StreakCompletedUpdater implements StreakUpdater { ... }
```

---

## 3️⃣ DEMONSTRAÇÃO DO SISTEMA (3 minutos)

### Ideias de como mostrar o sistema funcionando:

#### Opção 1: Demonstração via Postman/Insomnia
```bash
# 1. Iniciar a aplicação Spring Boot
cd clean-code
mvn spring-boot:run

# 2. Usar Postman para demonstrar os endpoints:
```

**Endpoints para demonstrar:**
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/todo` | Criar nova tarefa |
| GET | `/todo/{id}` | Buscar tarefa por ID |
| GET | `/todo/users/{userId}` | Listar tarefas do usuário |
| PUT | `/todo/{id}` | Atualizar status da tarefa |
| DELETE | `/todo/{id}` | Excluir tarefa |

#### Opção 2: Demonstração via Terminal/cURL
```bash
# Criar uma tarefa
curl -X POST http://localhost:8080/todo \
  -H "Content-Type: application/json" \
  -d '{"title": "Estudar SOLID", "description": "Revisar princípios", "authorId": 1, "statusTodo": "PENDING"}'

# Buscar tarefa
curl http://localhost:8080/todo/1

# Atualizar status
curl -X PUT http://localhost:8080/todo/1 \
  -H "Content-Type: application/json" \
  -d '{"statusTodo": "COMPLETED", "userId": 1}'
```

#### Opção 3: Mostrar Código Lado a Lado
```
┌─────────────────────────┬─────────────────────────┐
│      CÓDIGO RUIM        │     CÓDIGO LIMPO        │
│  (1 arquivo, 150 linhas)│  (Múltiplos módulos)    │
├─────────────────────────┼─────────────────────────┤
│  Main.java              │  TodoController.java    │
│  - criarTarefa()        │  TodoService.java       │
│  - alterarStatus()      │  TodoRepository.java    │
│  - excluirTarefa()      │  Todo.java              │
│  - verTarefas()         │  TodoMapper.java        │
│  - Iniciar() (UI)       │  DTOs, Commands, Queries│
└─────────────────────────┴─────────────────────────┘
```

#### Opção 4: Mostrar Estrutura no IDE
- Abrir IntelliJ/VS Code com ambos projetos
- Navegar pelas pastas mostrando a separação de responsabilidades
- Mostrar como a injeção de dependência funciona

---

## 📝 Conclusão (1 minuto)

### Benefícios Obtidos:

✅ **Testabilidade** - Cada camada pode ser testada isoladamente  
✅ **Manutenibilidade** - Mudanças em uma camada não afetam outras  
✅ **Escalabilidade** - Fácil adicionar novos módulos (User, Streak)  
✅ **Reutilização** - Componentes podem ser reusados em outros projetos  
✅ **Flexibilidade** - Posso trocar banco de dados sem alterar regras de negócio  

### Resumo:

> "A arquitetura em camadas transformou um código monolítico e acoplado em um sistema modular, testável e fácil de evoluir, seguindo os princípios SOLID e boas práticas de engenharia de software."

---

## 🔗 Links Úteis para Estudo

- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Domain-Driven Design](https://martinfowler.com/bliki/DomainDrivenDesign.html)
- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)
