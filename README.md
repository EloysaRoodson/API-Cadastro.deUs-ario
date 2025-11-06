<h2 align="center"> Sistema de Cadastro de Usuários – Java Spring Boot </h2>

<p align="center">Este projeto é uma API REST desenvolvida com Java 21 e Spring Boot, criada para demonstrar uma arquitetura moderna, organizada e segura no backend.
A aplicação gerencia informações de usuários com foco em boas práticas de código, validação de dados e respostas padronizadas, oferecendo um ambiente estável para futuras expansões.


<p align="center"> A API foi construída com uma estrutura em camadas (Controller, Service, Repository e Entity), garantindo separação de responsabilidades e facilidade de manutenção.
Todas as operações seguem o modelo CRUD, permitindo criar, consultar, listar e remover usuários de forma simples e segura.
O armazenamento é feito em um banco de dados H2 em memória, o que facilita os testes e execução local sem necessidade de configuração adicional. </p>

---

 ***Segurança e Tratamento de Dados***

- As senhas são criptografadas com BCrypt, garantindo sigilo e integridade.

- O ID é gerado automaticamente pelo banco de dados.

- As requisições são validadas antes de persistir os dados, evitando campos nulos, vazios ou formatos incorretos.

- Todas as respostas são retornadas em JSON, com mensagens claras de sucesso ou erro.
 
---

 ***Tecnologias Utilizadas***

- Java 21

- Spring Boot

- Spring Data JPA

- H2 Database (em memória)

- Postman (para testes de integração)

  ---

***Endpoints Principais***

- Método	Rota	Função
 
|GET	/API/usuarios	Lista todos os usuários|
|------------------------------------------|
|GET	/API/usuarios/{id}	Busca um usuário pelo ID|

|POST	/API/usuarios	Cadastra um novo usuário|
|-------------------------------------------------|
|DELETE	/API/usuarios/{id}	Exclui um usuário existente| 

---

 ***Exemplo de Cadastro (POST)***
 
{

  "nome": "Eloysa Roodson",
  
  "email": "eloysa@exemplo.com",
  
  "senha": "12345",
  
  "telefone": "61 91010-1010"
  
}


<p> Após o envio, a senha é automaticamente criptografada e salva de forma segura.</p>

 ***Retornos da API***
 
 Ação	Mensagem 
 |-------------------------------------------------|
|Cadastro	Usuário cadastrado com sucesso.|
|Exclusão	Usuário deletado com sucesso.|
|Erro de validação	Campos obrigatórios: nome, email e senha.|
|ID inválido	Usuário não encontrado.|
||

***Testes e Integração***

<p> O projeto conta com uma coleção no Postman, onde cada requisição foi configurada para validar: </p>

- Status HTTP retornado;

- Estrutura do JSON;

- Mensagens e respostas esperadas.

- As variáveis como {{base_url}} e {{usuario_id}} foram configuradas para facilitar os testes dinâmicos e reaproveitamento da coleção.

 <h1> Objetivo </h1>

<p> Este projeto foi desenvolvido com o propósito de aperfeiçoar habilidades em backend Java e demonstrar a aplicação prática de conceitos essenciais como:

. Camadas de arquitetura;

. Validação e segurança de dados;

. Integração com ferramentas de teste;

. Boas práticas de API REST. </p>

<p> Além disso, ele serve como base para futuras implementações de autenticação JWT e controle de acesso. </p>

<p> 💡 Um projeto simples, bem estruturado e totalmente funcional — ideal para representar boas práticas de desenvolvimento e organização no ecossistema Java + Spring Boot. </p>
