# 🍔 Raízes do Nordeste - Backend

Sistema backend desenvolvido em **Java + Spring Boot** para gerenciamento de produtos, pedidos, itens e pagamentos.

---

# 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven
- Swagger / OpenAPI
- Postman

---

# 📦 Funcionalidades

## 👤 Usuários
- Cadastro de usuários
- Login com autenticação
- Controle de perfis:
    - CLIENTE
    - ATENDENTE
    - COZINHA
    - GERENTE
    - ADMIN

---

## 🛒 Produtos
- Criar produto
- Listar produtos
- Controle de estoque

---

## 📄 Pedidos
- Criar pedido
- Listar pedidos
- Filtrar pedidos por canal
- Associação automática ao usuário autenticado

---

## 📋 Itens do Pedido
- Adicionar item ao pedido
- Baixa automática no estoque
- Validação de estoque insuficiente

---

## 💳 Pagamento (Mock)
- Aprovar pagamento
- Recusar pagamento
- Atualização automática do status do pedido

---

## ⚠️ Tratamento de Erros
- Retorno padronizado em JSON
- Mensagens claras para o cliente

### Exemplos:
- Pedido não encontrado
- Estoque insuficiente

---

# 🔗 Endpoints Principais

## 👤 Usuários

```http
POST /usuarios
POST /usuarios/login
GET /usuarios
```

---

## 🛒 Produtos

```http
GET /produtos
POST /produtos
```

---

## 📄 Pedidos

```http
GET /pedidos
GET /pedidos?canalPedido=APP
POST /pedidos
PUT /pedidos/{id}/status
```

---

## 📋 Itens

```http
GET /itens
POST /itens
```

---

## 💳 Pagamentos

```http
POST /pagamentos/pedido/{id}/aprovar
POST /pagamentos/pedido/{id}/recusar
```
---

# 🧪 Testes da API

Swagger:

```text
http://localhost:8080/swagger-ui.html
```

Também foi criada uma coleção no Postman contendo:

- Cadastro de usuário
- Login
- Cadastro de produto
- Criação de pedido
- Criação de item do pedido
- Aprovação de pagamento
- Recusa de pagamento
- Testes de erro

---

# ▶️ Como executar o projeto

## 1. Clonar repositório

```bash
git clone https://github.com/Dfdouglas/raizes-backend.git
```

---

## 2. Entrar na pasta do projeto

```bash
cd backend
```

---

## 3. Configurar PostgreSQL

Editar:

```text
src/main/resources/application.properties
```

---

## 4. Executar aplicação

```bash
mvn spring-boot:run
```

---

# 📂 Estrutura do Projeto

```text
src/main/java/com/raizes/backend
│
├── controller
├── service
├── repository
├── model
├── dto
├── config
└── exception
```

---

# 📌 Requisitos Atendidos

- API REST
- Persistência em banco PostgreSQL
- Controle de estoque
- Fluxo Pedido → Pagamento → Atualização de status
- Multicanalidade com canalPedido
- Autenticação e autorização
- Tratamento padronizado de erros
- Documentação Swagger/OpenAPI
- Coleção Postman
- Segurança básica e LGPD

---

# 📌 Observações

- Ambiente de testes utiliza H2 em memória.
- Projeto desenvolvido para fins acadêmicos.
- Senhas são armazenadas com criptografia e não são exibidas nas respostas da API.

---

# 👨‍💻 Autor

Douglas Correa Lucas