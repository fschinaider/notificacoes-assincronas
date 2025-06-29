###Sistema de Notificações Assíncronas com RabbitMQ

Este projeto é uma implementação simples de um sistema de notificações assíncronas baseado em RabbitMQ, com foco nos fundamentos de Sistemas Distribuídos.

#Objetivo

Demonstrar como é possível usar mensageria assíncrona para desacoplar serviços e garantir a entrega de mensagens a múltiplos consumidores, mesmo que sejam de naturezas diferentes (e-mail, SMS, push, etc.).

Tecnologias

- Java 17
- Spring Boot
- Spring AMQP
- RabbitMQ
- Maven

#Arquitetura

- Um serviço de envio (UserEventSender) publica eventos do tipo UserEvent em uma Fanout Exchange.
- A exchange está ligada a 3 filas:
  - email.queue
  - sms.queue
  - push.queue
- Apenas o consumidor de e-mail foi implementado.
- As mensagens recebidas são armazenadas em memória e exibidas em uma página web simples.

#Execução

1. Pré-requisitos

- Java 17+
- Maven
- RabbitMQ em execução local (porta 5672)

2. Rodar o RabbitMQ (via Docker, se preferir)

docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

Acesse o painel: http://localhost:15672
Usuário: guest — Senha: guest

3. Clonar e rodar o projeto

git clone <repo>
cd notificacoes
mvn clean install
mvn spring-boot:run

#Testar envio de mensagens

Realize uma requisição POST para o endpoint:

POST http://localhost:8080/api/user/register
Content-Type: application/json

{
  "userId": "123",
  "email": "exemplo@email.com",
  "phone": "11999999999"
}

Você verá no terminal:

Enviando e-mail para: exemplo@email.com | Nome: exemplo@email.com

Acessar painel de visualização

Acesse:

http://localhost:8080

Essa página é estática e exibe as notificações recebidas durante a execução do sistema, simulando um painel de acompanhamento.

Não foi utilizado banco de dados, pois o foco do trabalho é:
- Mostrar troca de mensagens entre serviços distribuídos
- Evitar acoplamento entre produtor e consumidor
- Usar fila como mecanismo de integração assíncrona

Caso a implementação evolua:

- Criar consumidores reais para sms.queue e push.queue
- Armazenar eventos em banco de dados com Spring Data
- Exibir notificações em tempo real via WebSocket ou API REST
"""

path = Path("/mnt/data/README_final.txt")
path.write_text(readme_text, encoding="utf-8")
path.name
