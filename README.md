# Api Customer

Cadastro de customers via api rest.<br>
Esta API disponibiliza endpoint para inserção de dados dos clientes.<br><br>


#### Prerequisities

* Java JDK 11+
* Maven
* [`docker-compose`](https://docs.docker.com/compose/install/)

## Contract First
* Import o arquivo src/main/resources/openApi.yaml no seu postman para testar os endpoints.


## Executando aplicação com container.

1 - Build da aplicação executando tests unitários:

    mvn clean package

4 - Start da aplicação, mongodb

    docker-compose -f deployment/docker-compose.yml up -d --build

5 - Logs app
    
    docker logs -f deployment_customers_1

6 - Shutdowning the Environment

    docker-compose -f deployment/docker-compose.yml stop
    docker-compose -f deployment/docker-compose.yml rm

## Executando aplicação no modo local.

1 - Build da aplicação executando tests unitários:

    mvn clean package

2 - Start da mongodb

    docker-compose -f deployment/docker-compose-local.yml up -d --build

3 - Start da Applicacao

    java -jar target/customer-crud-0.0.1-SNAPSHOT.jar --spring.profiles.active=local



## Documentação Api 
* [`Api Customer Documentation - Com serviço em execução clique aqui para acessar`](http://localhost:8080/swagger-ui.html)
