# PetSoft

## Descrição

O "PetSoft" visa gerenciar informações de uma clínica veterinária, incluindo cadastro de animais, agendamento de consultas e histórico de atendimentos. A API facilita o controle das operações, permitindo o gerenciamento eficaz dos dados dos pacientes.

## Pré-requisitos
- JDK 17


## Tabela de Conteúdos
- [Funcionalidades](#funcionalidades)
- [Instalação](#instalação)
- [Uso](#uso)
- [Acesso ao Sistema](#acesso-ao-sistema)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Licença](#licença)

## Funcionalidades
- Cadastro de clientes e seus pets

## Instalação

1. **Clone o repositório:
   ```bash
   git clone https://github.com/RobertoSantos98/trabalho-api.git
   ```
2. **Navegue até o diretório do projeto:**

   ```bash
   cd trabalho-api
   ```
3. **Compile e execute o projeto:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

A API estará disponível em `http://localhost:8080`.



## Uso

** Documentação da API (Swagger)

A documentação da API pode ser acessada por meio do Swagger. Após iniciar o backend, você pode acessar a documentação por meio da seguinte URL:

[/swagger-ui/index.html](http://localhost:8080//swagger-ui/index.html)


## Acesso ao Sistema

## Endpoints

Abaixo está a descrição dos principais endpoints da API:

{Alterar os endpoints conforme os endpoints do projeto}

### **1. GET /api/usuarios**

- **Descrição:** Retorna uma lista de usuários.
- **Parâmetros de Consulta:**
  - `page` (opcional): Número da página.
  - `size` (opcional): Número de itens por página.
- **Resposta:**
  - **200 OK**
    ```json
    [
      {
        "id": 1,
        "nome": "João",
        "cpf": "321.654.987-01"
	"animal": "Cão"
	"raca": "Pastor-Alemão"
      },
      // ...
    ]
    ```

### **2. POST /api/usuarios**

- **Descrição:** Cria um novo usuário.
- **Corpo da Requisição:**
  ```json
  {
    	"id": 1,
        "nome": "João",
        "cpf": "123.456.789-10"
	"animal": "Cão"
	"raca": "Pastor-Alemão"
  }
  ```
- **Resposta:**
  - **201 Created**
    ```json
    {
      "id": 2,
      "nome": "Maria",
      "cpf": "123.456.789-10"
    }
    ```

### **3. GET /api/usuarios/{id}**

- **Descrição:** Retorna um usuário específico pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do usuário.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 1,
      "nome": "João",
      "cpf": "123.456.789-10"
      "animal": "Cão"
      "raca": "Pastor-Alemão"
    }
    ```
  - **404 Not Found** (se o usuário não for encontrado)

### **4. PUT /api/usuarios/{id}**

- **Descrição:** Atualiza um usuário existente.
- **Corpo da Requisição:**
  ```json
  {
    "nome": "João Atualizado",
    "cpf": "123.456.789-41"
  }
  ```
- **Parâmetros de Caminho:**
  - `id`: ID do usuário.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 1,
      "nome": "João Atualizado",
      "cpf": "123.456.789-10"
      "animal": "Cão"
      "raca": "Pastor-Alemão"
    }
    ```
  - **404 Not Found** (se o usuário não for encontrado)

### **5. DELETE /api/usuarios/{id}**

- **Descrição:** Remove um usuário pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do usuário.
- **Resposta:**
  - **204 No Content**
  - **404 Not Found** (se o usuário não for encontrado)

## Tecnologias Utilizadas
- **Back-end**: Spring-boot
- **Banco de Dados**: h2
- **Front-end**: De sua escolha.


## Licença
Este projeto está licenciado sob a [BrazCubas](LICENSE-00000010001010101).

