## Requisitos
    - Java 11
    - RabbitMQ 
        docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

## Build
    ./gradlew build
        

## Executando app
    Irá gerar um arquivo .jar dentro do diretorio /build/lib/demo-0.0.1-SNAPSHOT.jar
    Navegue para dentro da pasta e execute : java -jar demo-0.0.1-SNAPSHOT.jar

## API
    ### Produzir mensagem
    http://localhost:9090/{message}
    
    ### Consumir mensagens
    http://localhost:9090/pull
        
## Referencias
   https://www.rabbitmq.com/api-guide.html#consuming

   https://www.rabbitmq.com/download.html
   
