Oficina Roluka - Sistema de Gestão de Ordens de Serviço

Sistema fullstack com Java + Spring Boot(backend) e Angular(frontend) para controle de clientes, veículos, peças e ordens de serviço de uma oficina mecânica.

Funcionalidades

- Cadastro, listagem, edição e exclusão de clientes
- Cadastro, listagem, edição e exclusão de veículos
- Criação de ordens de serviço com vínculo ao cliente e veículo
- Busca de cliente por CPF para facilitar o preenchimento da ordem
- Validação automática de CPF ou CNPJ via anotação customizada
- Dropdown dinâmico para veículos ao selecionar o cliente
- Validação de campos obrigatórios com feedback visual
- Layout responsivo com PrimeNG e PrimeFlex

Tecnologias utilizadas

Backend
- Java 17
- Spring Boot 3
- Spring Data JPA
- Hibernate Validator com anotação personalizada @ValidCPFouCNPJ
- H2 Database 
- Maven

Frontend
- Angular 17
- PrimeNG
- PrimeFlex
- Angular Forms (reativos)
- Consumo de API REST

Como rodar o projeto

Backend (Spring Boot)

1. Abra o projeto no VS Code com extensão Spring
2. Execute a classe OficinaRolukaApplication.java
3. Acesse o backend em http://localhost:8080

Frontend (Angular)

1. Acesse a pasta frontend pelo terminal
2. Executar o comando no terminal: npm install
3. Acessar o frontend em http:/locallhost:4200

Resumo da estrutura do projeto

backend/
 └── com.senai.oficinaroluka
      ├── controller/
      ├── service/
      ├── model/
      ├── repository/
      ├── validation/
      └── util/

frontend/
 └── src/app/
      ├── components/
      ├── services/
      ├── models/
      └── pages/


Padrões de Projeto Aplicados:

-Singleton (serviços Spring)
-Strategy (validação CPF/CNPJ)
-Factory Method (Angular FormBuilder)
-Iterator (Angular ngFor / PrimeNG dropdown)
-MVC (Spring Controller + Angular Components)


O que o sistema faz:

O sistema da Oficina Roluka ofere uma gestão inteligente para as oficinas mecanicas.
O mecânico cadastra os clientes de forma rápida, com validação automática de CPF ou CNPJ.

-Pode associar veículos diretamente aos clientes.
-Cadastra clientes, veiculos e peças e terá melhorias para gestão de estoque.
-Gera ordens de serviço com status (ABERTA, EM ANDAMENTO, CONCLUÍDA), vinculadas ao cliente e ao seu veículo.
-Basta digitar o CPF e o sistema já puxa todos os dados do cliente(nome e veículos)

Por trás da tela, atoa um backend em Java com Spring Boot que garante a persistência dos dados, segurança nas validações e escalabilidade para futuras melhorias.




