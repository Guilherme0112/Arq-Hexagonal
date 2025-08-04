# Projeto - Core + Messaging + Kafka (Arquitetura Hexagonal)

## Visão Geral
Este projeto é composto por múltiplos serviços Dockerizados que trabalham em conjunto para fornecer uma arquitetura modular, escalável e desacoplada:

- **Core**  
  Serviço principal implementado em **Spring Boot** seguindo **Arquitetura Hexagonal**.  
  Ele expõe as regras de negócio e interage com o banco de dados **PostgreSQL**.

- **Messaging**  
  Serviço separado responsável por envio de e-mails e consumo de mensagens assíncronas via **Kafka**.

- **Kafka**  
  Middleware de mensageria que permite comunicação assíncrona entre os serviços.

- **Kafka UI**  
  Interface gráfica para monitoramento e gerenciamento dos tópicos, brokers e consumidores Kafka.

- **PostgreSQL**  
  Banco de dados relacional utilizado pelo serviço **Core**.

---

## Arquitetura

```
             ┌─────────────┐
             │   Core      │
             │(Hexagonal)  │
             └──────┬──────┘
                    │
                    ▼
            ┌─────────────┐
            │  PostgreSQL │
            └─────────────┘
                    ▲
                    │ (mensageria assíncrona)
                    ▼
            ┌─────────────┐
            │  Messaging  │
            │ (Emails)    │
            └──────┬──────┘
                   │
                   ▼
               ┌───────┐
               │ Kafka │
               └───┬───┘
                   │
                   ▼
               ┌───────┐
               │KafkaUI│
               └───────┘
```

---

## Serviços

### 1. Core
- **Tecnologia**: Java 17 + Spring Boot  
- **Arquitetura**: Hexagonal  
- **Função**: Contém o domínio e casos de uso principais. Comunica-se com `Messaging` via Kafka.  
- **Porta**: `8080`

### 2. Messaging
- **Tecnologia**: Java 17 + Spring Boot  
- **Função**: Envio de e-mails e processamento de mensagens recebidas de tópicos Kafka.  
- **Porta**: `8081`

### 3. Kafka
- **Função**: Permite troca de mensagens assíncronas entre Core e Messaging.  
- **Porta**: `9092`

### 4. Kafka UI
- **Função**: Interface para gerenciamento dos tópicos, brokers e consumidores Kafka.  
- **Porta**: `9091`

### 5. PostgreSQL
- **Função**: Banco de dados para persistência do Core.  
- **Porta**: `5432`

---

## Requisitos
- **Docker** e **Docker Compose** instalados.

---

## Como Executar
```bash
docker compose up --build
```

Isso irá subir todos os serviços:
- Core (`localhost:8080`)
- Messaging (`localhost:8081`)
- Kafka (`localhost:9092`)
- Kafka UI (`localhost:9091`)
- PostgreSQL (`localhost:5432`)

---

## Observações
- O Core e Messaging usam comunicação assíncrona via Kafka, mantendo baixo acoplamento.
- O Kafka UI facilita o monitoramento e gerenciamento dos tópicos e consumidores.
- Toda a infraestrutura é orquestrada pelo Docker Compose.
