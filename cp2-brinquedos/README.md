# CP2 - Sistema de Brinquedos 🧸

**FIAP – Curso de TDS | Checkpoint 2 – Spring Boot com Persistência**

Sistema REST para gerenciamento de brinquedos infantis (até 14 anos), desenvolvido com Spring Boot, JPA e banco Oracle.

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Data JPA (Hibernate)
- Spring Validation
- Oracle Database (FIAP)
- Tomcat (porta 8080)
- Postman (testes dos endpoints)

---

## ⚙️ Configuração do Spring Initializr

| Campo       | Valor                        |
|-------------|------------------------------|
| Project     | Maven                        |
| Language    | Java                         |
| Spring Boot | 3.4.5                        |
| Group       | fiap.com.br                  |
| Artifact    | cp2-brinquedos               |
| Java        | 21                           |

**Dependências selecionadas:**
- Spring Web
- Spring Data JPA
- Spring Validation
- Oracle Driver
- Spring Boot DevTools

---

## 📦 Estrutura do Projeto

```
cp2-brinquedos/
├── src/main/java/fiap/com/br/brinquedos/
│   ├── BrinquedosApplication.java       ← Classe principal
│   ├── model/
│   │   └── Brinquedo.java               ← Entidade JPA (tabela Oracle)
│   ├── dto/
│   │   └── BrinquedoDto.java            ← DTO com validações
│   ├── repository/
│   │   └── BrinquedoRepository.java     ← Interface JPA Repository
│   ├── service/
│   │   └── BrinquedoService.java        ← Lógica de negócio
│   ├── controller/
│   │   └── BrinquedoController.java     ← Endpoints REST
│   └── exception/
│       └── GlobalExceptionHandler.java  ← Tratamento de erros
└── src/main/resources/
    └── application.properties           ← Config Oracle + JPA
```

---

## 🗄️ Banco de Dados Oracle

**Tabela:** `TDS_TB_Brinquedos`

| Coluna        | Tipo          | Descrição                     |
|---------------|---------------|-------------------------------|
| id            | NUMBER (PK)   | Identificador único           |
| nome          | VARCHAR2(100) | Nome do brinquedo             |
| tipo          | VARCHAR2(50)  | Categoria (Boneca, Carrinho…) |
| classificacao | VARCHAR2(20)  | Faixa etária (+3, +7, Livre…) |
| tamanho       | VARCHAR2(20)  | Pequeno / Médio / Grande      |
| preco         | NUMBER        | Preço em Reais                |

> A tabela é criada automaticamente pelo Hibernate (`ddl-auto=update`).

---

## 🔗 Endpoints CRUD

Base URL: `http://localhost:8080/brinquedos`

| Método | Endpoint             | Descrição              |
|--------|----------------------|------------------------|
| POST   | /brinquedos          | Criar novo brinquedo   |
| GET    | /brinquedos          | Listar todos           |
| GET    | /brinquedos/{id}     | Buscar por ID          |
| PUT    | /brinquedos/{id}     | Atualizar brinquedo    |
| DELETE | /brinquedos/{id}     | Excluir por ID         |

---

## 📝 Exemplos de JSON para Testes no Postman

### ✅ POST – Criar Brinquedo
**URL:** `POST http://localhost:8080/brinquedos`
```json
{
  "nome": "Carrinho Hot Wheels Turbo",
  "tipo": "Carrinho",
  "classificacao": "+3",
  "tamanho": "Pequeno",
  "preco": 29.90
}
```
**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "Carrinho Hot Wheels Turbo",
  "tipo": "Carrinho",
  "classificacao": "+3",
  "tamanho": "Pequeno",
  "preco": 29.90
}
```

---

### ✅ POST – Outro exemplo
```json
{
  "nome": "Boneca Barbie Fashionista",
  "tipo": "Boneca",
  "classificacao": "+3",
  "tamanho": "Médio",
  "preco": 89.99
}
```

---

### ✅ GET – Listar todos
**URL:** `GET http://localhost:8080/brinquedos`

**Resposta (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "Carrinho Hot Wheels Turbo",
    "tipo": "Carrinho",
    "classificacao": "+3",
    "tamanho": "Pequeno",
    "preco": 29.90
  },
  {
    "id": 2,
    "nome": "Boneca Barbie Fashionista",
    "tipo": "Boneca",
    "classificacao": "+3",
    "tamanho": "Médio",
    "preco": 89.99
  }
]
```

---

### ✅ GET – Buscar por ID
**URL:** `GET http://localhost:8080/brinquedos/1`

**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "Carrinho Hot Wheels Turbo",
  "tipo": "Carrinho",
  "classificacao": "+3",
  "tamanho": "Pequeno",
  "preco": 29.90
}
```

**Resposta quando não encontrado (404):**
```json
{
  "erro": "Brinquedo com ID 99 não encontrado."
}
```

---

### ✅ PUT – Atualizar Brinquedo
**URL:** `PUT http://localhost:8080/brinquedos/1`
```json
{
  "nome": "Carrinho Hot Wheels Turbo XL",
  "tipo": "Carrinho",
  "classificacao": "+5",
  "tamanho": "Médio",
  "preco": 39.90
}
```
**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "Carrinho Hot Wheels Turbo XL",
  "tipo": "Carrinho",
  "classificacao": "+5",
  "tamanho": "Médio",
  "preco": 39.90
}
```

---

### ✅ DELETE – Excluir por ID
**URL:** `DELETE http://localhost:8080/brinquedos/1`

**Resposta (204 No Content):** sem corpo na resposta.

---

### ❌ Exemplo de erro de validação (POST com dados inválidos)
```json
{
  "nome": "",
  "tipo": "Carrinho",
  "classificacao": "+3",
  "tamanho": "Pequeno",
  "preco": -10
}
```
**Resposta (400 Bad Request):**
```json
{
  "nome": "O nome é obrigatório",
  "preco": "O preço deve ser maior que zero"
}
```

---

## ▶️ Como Executar

1. Clone o repositório
2. Abra no IntelliJ IDEA
3. Configure `application.properties` com seu RM e senha Oracle FIAP
4. Execute `BrinquedosApplication.java`
5. Teste os endpoints no Postman na URL `http://localhost:8080/brinquedos`
