# 📦 Estudo JPA

Projeto de estudos desenvolvido durante o curso **Spring Boot: aprenda a criar sistemas Java completos** do professor **Nélio Alves (Udemy)**, com o objetivo de praticar e fixar os principais conceitos de back-end com Spring Boot e JPA/Hibernate.

> ⚠️ Este é um projeto **focado 100% em back-end**, sem interface front-end — a proposta é treinar a construção de APIs REST robustas.

---

## 🚀 Tecnologias utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (banco em memória para testes)
- **Lombok**
- **Maven**

---

## 🧩 Estrutura do domínio

O projeto simula um sistema de e-commerce simplificado, com as seguintes entidades principais:

| Entidade   | Descrição                                                        |
|------------|-------------------------------------------------------------------|
| `User`     | Usuários/clientes do sistema                                     |
| `Category` | Categorias de produtos                                            |
| `Product`  | Produtos disponíveis para venda                                   |
| `Order`    | Pedidos realizados pelos usuários                                 |
| `Payment`  | Pagamento associado a um pedido (`@OneToOne`)                     |
| `OrderItem`| Itens de um pedido, associando produto e pedido (`@ManyToMany`)   |

### Relacionamentos JPA aplicados
- `@ManyToOne` → um pedido pertence a um cliente
- `@OneToMany` → um pedido possui vários itens
- `@OneToOne` → um pedido possui um pagamento
- `@Enumerated(EnumType.STRING)` → status do pedido (`OrderStatus`)
- `@JsonFormat` → formatação customizada de datas (`Instant`)

---

## 🔌 Endpoints REST (exemplo: `/users`)

| Método | Rota            | Descrição                          |
|--------|-----------------|-------------------------------------|
| GET    | `/users`        | Lista todos os usuários             |
| GET    | `/users/{id}`   | Busca um usuário por ID             |
| POST   | `/users/insert` | Insere um novo usuário              |
| PUT    | `/users/{id}`   | Atualiza um usuário existente       |
| DELETE | `/users/delete/{id}` | Remove um usuário              |

A mesma estrutura de CRUD (Controller → Service → Repository) é aplicada às demais entidades do domínio.

---

## 📁 Estrutura de pacotes

```
src/main/java/com/est_jpa/estudo_jpa/
├── Category
├── common
├── config
├── Exception
├── Order
├── Payment
├── Product
├── User
└── EstudoJpaApplication.java
```

---

## ▶️ Como executar o projeto

### Pré-requisitos
- JDK 17+
- Maven (ou use o wrapper `mvnw` incluso no projeto)

### Passos

```bash
# Clone o repositório
git clone <link-do-repositorio>

# Acesse a pasta do projeto
cd estudo-jpa

# Rode a aplicação
./mvnw spring-boot:run
```

A aplicação sobe por padrão em:
```
http://localhost:8080
```

### Console do H2
Enquanto a aplicação estiver rodando, o console do banco H2 pode ser acessado em:
```
http://localhost:8080/h2-console
```

---

## 🎯 Objetivo do projeto

Este repositório não tem fins comerciais — é um projeto de **estudo e prática**, criado para consolidar conhecimentos sobre:

- Arquitetura em camadas no Spring Boot
- Mapeamento objeto-relacional com JPA/Hibernate
- Boas práticas de APIs REST
- Tratamento de exceções personalizadas
- Uso de DTOs e serviços

---

## 📚 Créditos

Projeto baseado no curso [Java COMPLETO Programação Orientada a Objetos + Projetos](https://www.udemy.com/course/java-curso-completo/?couponCode=KEEPLEARNING/) do professor **Nélio Alves**.

---

## 📝 Licença

Este projeto é livre para fins de estudo.
