build:
	docker build -t train-me-service -f Dockerfile .

start:
	docker-compose up -d --build

producer-test:
	sh src/main/resources/kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

consumer-test:
	sh src/main/resources/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

.PHONY: build start producer-test consumer-test