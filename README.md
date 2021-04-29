## Requisitos
    - Java 11
    - RabbitMQ 
        docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
        
## API
    ### Produzir mensagem
    http://localhost:9090/{message}
    
    ### Consumir mensagens
    http://localhost:9090/pull
        
## Referencias
   https://www.rabbitmq.com/api-guide.html#consuming
   https://www.rabbitmq.com/download.html
   
