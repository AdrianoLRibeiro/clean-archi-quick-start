# Clean Architecture Quick Start

Esse projeto é a estrutura básica de uma aplicação Springboot usando Clean Architecture

------

### Ferramentas utilizadas
    -   Java 8
    -   Springboot
    -   Lombok
    -   Docker Compose
    -   Swagger
    -   Git
    -   Gradle
    -   JUnit
    -   Mockito
    -   etc

------

### Instruções
Para executar a aplicação, é necessário ter um docker-compose rodando na máquina.

Para utilizar esse projeto o plugin lombok deverá estar habilitado na IDE.
    
Rode o build:

`./gradlew clean build`

Navegue até o diretório `docker` do projeto e execute o seguite comando: 
`sudo docker-compose up`

O serviço deve estar disponível na url: 

`http://localhost:8080/swagger-ui.html`
 
Acessando esse recurso é possível ver os endpoints disponibilizados para implementar os requisitos solicitados.

------

### Arquitetura

A aplicação foi desenvolvida usando os princípios de Clean Architecture de Robert Martin como pode ser visto no 
site 

http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html


Esse estilo de arquitetura faz com os circulos mais internos que representam a camada de domínio da aplicação onde devem
ficar de fato as regras de negócio da aplicação não consigam enxergar os mais externos que representam as camadas de 
infraestrutura. 

[<img src="http://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg">](http://google.com.au/)

Seguindo esse princípio, é possivel obter uma arquitetura mais desacoplada e qualquer alteração nas camadas externas 
não impactam as camadas mais internas onde ficam as regras de negócio o que é extremamente interessante para aplicações 
com vida útil longa.

Para chegar a esse nível de desacoplamento, foi utilizado o Gradle para modularizar a aplicação e controlar a visibilidade 
entre os componentes.

------
