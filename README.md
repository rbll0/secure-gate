# 🔐 SecureGate - Backend Antifraude

Sistema backend desenvolvido em Java com Spring Boot para validação de biometria facial, biometria digital e documentos, com simulação de detecção de fraudes e integração com sistema de notificações da QUOD.

---

## 📌 Descrição

O SecureGate é um sistema antifraude que processa dados biométricos e documentos capturados pelo aplicativo frontend, realizando:

- Validação básica e avançada de imagens.
- Simulação de fraudes como deepfake, máscaras e foto de foto.
- Persistência em banco de dados NoSQL (MongoDB).
- Notificações automáticas para casos suspeitos.

---

## 🚀 Funcionalidades

- 📸 **Validação facial** com simulação de fraudes.
- 🖐 **Validação de impressões digitais**.
- 🪪 **Validação de documentos com frente e verso**.
- ⚠️ **Detecção e rastreamento de fraudes**.
- 📡 **Notificação via HTTP ao sistema da QUOD** em casos de fraude.

---

## 📂 Estrutura do Projeto

- `configs/` – Configurações globais (ex: MongoDB, Exception Handling)
- `domains/` – Entidades de negócio (biometria, documentos, validação)
- `gateways/` – Controllers, DTOs, repositórios e responses
- `usecases/` – Regras de negócio e validações

---

## 🔧 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.4**
- **MongoDB (local)** – `mongodb://localhost:27017/securegate-db`
- **Swagger/OpenAPI**
- **Lombok**
- **JUnit 5 + WebMvcTest**

---

## 📬 Endpoints (via Swagger/Postman)

Base URL: `http://localhost:8080/api/validate`

- `POST /api/validate` – Recebe dados de biometria ou documento e retorna o resultado da validação.
- Requisições devem conter dados no formato JSON, com campos conforme o tipo: `facial`, `fingerprint` ou `document`.

---

## 🧪 Testes

- Testes unitários de serviços e controller incluídos
- Validação com Postman/Insomnia simulando todos os fluxos

---

## 👥 Integrantes

| Nome                        | RM      |
|-----------------------------|---------|
| Diego Silva Cavalcanti      | 553351  |
| Kaio de Souza Barbosa       | 553983  |
| Vinícius de Souza Barbosa   | 553998  |
| Mateus Galeazi de Oliveira  | 553352  |
| Gustavo Rabelo Frere        | 553326  |

---

## 📄 Modelo C4 (Arquitetura)

📌 O projeto segue o modelo C4 em camadas:
1. **Controller (API)**
2. **UseCases (Negócio)**
3. **Gateways (Repositórios/Notificações)**
4. **Infraestrutura (MongoDB, Config)**

---

## 📥 Como Executar Localmente

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/securegate.git
```

2. Suba o MongoDB local (pode usar Docker):
```bash
docker run -d -p 27017:27017 --name mongodb mongo
```

3. Execute a aplicação com:
```bash
./mvnw spring-boot:run
```

4. Acesse a documentação da API em:
```
http://localhost:8080/swagger-ui/index.html
```
