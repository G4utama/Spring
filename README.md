# Spring

## start maven

```bash
./mvnw spring-boot:run
```

## Database

### login

```bash
sudo -u postgres psql
```

### db list

```bash
\l
```

### enter db

```bash
\c demo
```

### relation list

```bash
\d
```

### select from table

```bash
SELECT * FROM employee;
```

### drop table

```bash
DROP TABLE employee;
```

### exit

```bash
\q
```

## Docker

### consumer

```bash
docker-compose exec kafka kafka-console-consumer.sh --topic employee_topic --from-beginning --bootstrap-server kafka:9092
```

### producer

```bash
docker-compose exec kafka kafka-console-consumer.sh --topic employee_topic --from-beginning --bootstrap-server kafka:9092
```