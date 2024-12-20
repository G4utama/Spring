# Spring

## Start maven

```bash
./mvnw spring-boot:run
```

## Docker

### topic list
```bash
docker-compose exec kafka kafka-topics.sh --list --bootstrap-server kafka:9092
```

### consumer

```bash
docker-compose exec kafka kafka-console-consumer.sh --topic employee_topic --from-beginning --bootstrap-server kafka:9092
```

### producer

```bash
docker-compose exec kafka kafka-console-producer.sh --topic employee_topic --bootstrap-server kafka:9092
```

### postgres
```bash
docker-compose exec postgres psql -U postgres demo
```