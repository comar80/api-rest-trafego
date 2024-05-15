# API REST para registro de tráfego
### Feita em Java usando Spring Boot, Spring Data JPA, Spring Security, Flyway, Lombock, JWT e Docker
Inserir credencias do banco de dados em application.properties

## Build com Docker:
docker build -t trafego:v1 .

## Iniciando o container:
docker container run --name trafego-container -d -p 8080:8080 trafego:v1

## MER
![MER do Banco de Dados](https://github.com/comar80/api-rest-trafego/blob/main/MER.jpg)


