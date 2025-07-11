
# 📘 Projeto Gerar

**Projeto Gerar** é uma aplicação web desenvolvida em Java com Spring Boot para apoiar gestantes, oferecendo um CRUD de indicações de maternidades, ONGs, doulas e obstetras.

---

## 📦 Funcionalidades

- ✅ CRUD de indicações (nome, tipo, endereço, telefone, descrição, etc.)
- ✅ Validação dos dados (ex: telefone com 11 dígitos numéricos)
- ✅ Documentação interativa da API com Swagger
- ✅ Tratamento de erros de validação (resposta clara do que está errado)

---

## 🧱 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Maven
- MySQL
- Spring Data JPA
- Bean Validation (Jakarta Validation)
- Swagger (via Springdoc OpenAPI)
- Lombok

---

## 🛠️ Como executar o projeto localmente

1. **Clone o projeto:**

```bash
git clone https://github.com/brunadoliveiraa/projetogerar.git
cd projetogerar
```

2. **Configure o banco MySQL:**

Crie um banco com o nome:

```sql
CREATE DATABASE projetogerar;
```

3. **Configure o arquivo `application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projetogerar
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

4. **Rode o projeto:**

Via terminal:

```bash
./mvnw spring-boot:run
```

Ou direto pelo IntelliJ (`ProjetoGerarApplication.java`)

---

## 📑 Acessos úteis

- **Swagger UI (documentação da API):**  
  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

- **Endpoints (exemplos):**  
  `POST /indicacao` → Criar uma indicação  
  `GET /indicacao` → Listar todas as indicações

---

## 📥 Exemplo de JSON válido para criar indicação:

```json
{
  "id": 0,
  "nome": "Centro Médico Glória D'Or",
  "tipo": "Maternidade",
  "endereco": "Rua da Glória 122",
  "descricao": "Centro médico para consultas e exames de pré-natal",
  "telefone": "21981225637",
  "numNotas": 0,
  "sumNotas": 0
}
```

---

## 🚨 Validações

- O campo `telefone` deve conter **exatamente 11 dígitos numéricos**
- Todos os campos são obrigatórios

---

## 💬 Contribuição

Esse projeto foi desenvolvido como parte de um trabalho final para o curso Recode PRO IA 2025. Sugestões, melhorias e colaborações são bem-vindas!
