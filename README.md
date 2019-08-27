# spring-kafka
Planning around with Kafka and Spring

## Kafkacat

Kafkacat makes it easy to both produce and consume from a Kafka topic from the command line. This is good for testing our Kafka broker is working correctly.

Kafkacat can be installed with homebrew.

```
brew install kafkacat
```

### Testing the producer in Docker

You can publish some messages into a topic by running the following command.

```
kafkacat -P -b {kafka-ip}:9092 -t test
```

### Testing the consumer in Docker

You can consume the messages from the beginning offset by running the following command.

```
kafkacat -C -b {kafka-ip}:9092 -t test 
```

### Helpful links

- https://stackoverflow.com/questions/35861501/kafka-in-docker-not-working
- https://rmoff.net/2018/08/02/kafka-listeners-explained/
- https://www.confluent.io/blog/apache-kafka-spring-boot-application