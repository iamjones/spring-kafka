# spring-kafka
Planning around with Kafka and Spring

## Testing the producer in Docker

You can publish some messages into a topic by running the following command.

```
sh src/main/resources/kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
```

Or this for short.

```
make producer-test
```

## Testing the consumer in Docker

You can consume the messages from the beginning offset by running the following command.

```
sh src/main/resources/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
```

Or this for short.

```
make consumer-test
```