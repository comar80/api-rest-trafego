# API REST para registro de tráfego
### Feita em Java usando Spring Boot, Spring Data JPA, Spring Security, Flyway, Lombock, JWT e Docker
#### CI e CD com Github Actions e deploy na Azure

## Build e execução com Docker:
Trocar a DATABASE_URL do arquivo compose.yaml para: jdbc:mysql://db:3306/api?createDatabaseIfNotExist=true
```sh
docker compose up --build
```

### Link Azure / documentação via Swagger:
[Swagger](https://api-trafego-dev-dda3bhdng8gtaqhk.eastus2-01.azurewebsites.net/swagger-ui/index.html)

## MER
![MER do Banco de Dados](https://github.com/comar80/api-rest-trafego/blob/main/MER.jpg)
