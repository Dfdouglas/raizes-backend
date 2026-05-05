# 🍔 Raízes do Nordeste - Backend

Sistema backend desenvolvido em **Java + Spring Boot** para gerenciamento de pedidos, produtos, itens e pagamentos.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger (OpenAPI)
- Maven

---

## 📦 Funcionalidades

### 🛒 Produtos
- Criar produto
- Listar produtos

### 📄 Pedidos
- Criar pedido
- Listar pedidos
- Filtrar pedidos por canal

### 📋 Itens do Pedido
- Adicionar item ao pedido
- Listar itens

### 💳 Pagamento (Mock)
- Aprovar pagamento
- Recusar pagamento
- Atualiza status do pedido automaticamente

### ⚠️ Tratamento de erros
- Retorno padronizado em JSON
- Mensagens claras (ex: Pedido não encontrado)

---

## 🔗 Endpoints principais

### Produtos
- `GET /produtos`
- `POST /produtos`

### Pedidos
- `GET /pedidos`
- `GET /pedidos?canalPedido=APP`
- `POST /pedidos`

### Itens
- `GET /itens`
- `POST /itens`

### Pagamentos
- `POST /pagamentos/pedido/{id}/aprovar`
- `POST /pagamentos/pedido/{id}/recusar`

---

## 🧪 Testes

Os testes podem ser realizados via Swagger:

```text
http://localhost:8080/swagger-ui.html
