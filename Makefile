build:
	docker build -t train-me-service -f Dockerfile .

start:
	docker-compose up -d --build

.PHONY: build start