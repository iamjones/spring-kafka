build:
	docker build -t train-me-service -f Dockerfile .

start:
	docker-compose up -d --build

up:
	docker-compose up -d

.PHONY: build start up