# GitHub Manager

## Descrição
O GitHub Manager é uma aplicação Spring Boot que fornece uma interface REST para gerenciar e interagir com recursos do GitHub, 
focando principalmente no gerenciamento de commits e pull requests.

## Funcionalidades

### Gerenciamento de Commits
- Consulta de commits
- Acompanhamento de histórico de alterações
- Gerenciamento de commits em diferentes branches

### Gerenciamento de Pull Requests
- Criação e consulta de pull requests
- Acompanhamento do status de PRs
- Gerenciamento do ciclo de vida de pull requests

## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- Jakarta EE
- Lombok
- REST APIs

## Arquitetura
O projeto segue uma arquitetura hexagonal (ports and adapters) com:
- Controllers REST para entrada de dados
- Portas e adaptadores bem definidos
- Separação clara entre camadas de aplicação e infraestrutura

## Como Usar

### Pré-requisitos
- JDK 21
- Maven
- IDE compatível com Spring Boot

### Configuração
1. Clone o repositório
2. Configure as credenciais do GitHub no arquivo de configuração
3. Execute a aplicação usando Maven ou sua IDE preferida

## Endpoints da API

### Commits
- Endpoints para gerenciamento de commits
- Operações relacionadas ao histórico de commits

### Pull Requests
- Endpoints para gerenciamento de pull requests
- Operações de criação e atualização de PRs

## Contribuindo
Contribuições são bem-vindas! Por favor, siga os seguintes passos:
1. Faça um fork do projeto
2. Crie sua branch de feature (`git checkout -b feature/NovaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/NovaFeature`)
5. Abra um Pull Request

## Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.