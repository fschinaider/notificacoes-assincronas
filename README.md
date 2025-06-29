# Sistema de Notificações Assíncronas com RabbitMQ

Este projeto é uma implementação simples de um sistema de notificações assíncronas baseado em RabbitMQ, com foco nos fundamentos de Sistemas Distribuídos.

## Objetivo

Demonstrar como usar mensageria assíncrona para desacoplar serviços e garantir a entrega de mensagens a múltiplos consumidores, mesmo que sejam de naturezas diferentes (e-mail, SMS, push, etc.).

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring AMQP
- RabbitMQ
- Maven
- Docker (para executar o RabbitMQ)

## Arquitetura

- Um serviço de envio (`UserEventSender`) publica eventos do tipo `UserEvent` em uma **Fanout Exchange**.
- A exchange está ligada a três filas:
  - `email.queue`
  - `sms.queue`
  - `push.queue`
- Apenas o consumidor de **e-mail** foi implementado.
- As mensagens recebidas são armazenadas em **memória** e exibidas em uma **página web simples** (estática).

## Como Executar

### 1. Pré-requisitos

- Java 17+
- Maven
- Docker (opcional, se quiser rodar o RabbitMQ via container)

### 2. Rodar o RabbitMQ com Docker

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

Acesse o painel do RabbitMQ em:  
[http://localhost:15672](http://localhost:15672)  
Login: `guest`  
Senha: `guest`

### 3. Clonar o projeto e executar

```bash
git clone https://github.com/fschinaider/notificacoes-assincronas.git
cd notificacoes-assincronas
mvn clean install
mvn spring-boot:run
```

## Testar envio de mensagens

Faça uma requisição POST para o endpoint:

```
POST http://localhost:8080/api/user/register
Content-Type: application/json
```

Exemplo de corpo da requisição:

```json
{
  "userId": "123",
  "email": "exemplo@email.com",
  "phone": "11999999999"
}
```

Você verá no terminal:

```
Enviando e-mail para: exemplo@email.com | Nome: exemplo@email.com
```

## Visualizar mensagens

Acesse [http://localhost:8080](http://localhost:8080) para ver a página de visualização estática com as notificações recebidas **durante a execução**.

## Observações

- Não foi utilizado banco de dados. As mensagens são armazenadas temporariamente em memória.
- A página web é apenas para simulação da visualização das notificações.

## Possíveis Extensões Futuras

- Implementar consumidores reais para `sms.queue` e `push.queue`.
- Armazenar eventos em banco de dados com Spring Data.
- Exibir notificações em tempo real via WebSocket ou uma API REST com polling.
