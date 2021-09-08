#:: Password Verify API ::

API web que valida se uma senha é válida ou não!

A senha considerada válida, deve contar os requisitos abaixo:

* Nove ou mais caracteres
* Ao menos 1 dígito
* Ao menos 1 letra minúscula
* Ao menos 1 letra maiúscula
* Ao menos 1 caractere especial
* Considere como especial os seguintes caracteres: !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto
* Não possuir espaços em branco


##Tecnologias utilizadas

Para montar essa API, utilizei as seguintes tecnologias:

* [Gradle](https://gradle.org)
* [Kotlin](https://kotlinlang.org/)
* [Spring Boot](https://spring.io)


##Arquitetura da API

* application
    * web
        * controllers
        * exceptions
        * requests
        * responses
        * services

As rotas são executadas através das classes de Controller, que por fim executa a chamada para as classes de
Service, onde contém toda a regra de negócio.


## Como buildar a aplicação

Pode-se executar a aplicação em sua IDE de preferência. No meu caso, utilizei a IDE IntelliJ para desenvolver e
executar a aplicação.

Verifique se sua IDE possui suporte a linguagem Kotlin, talvez seja necessário instalar as dependências do Kotlin para
conseguir buildar a aplicação.

Após isso, basta executar a classe **PasswordVerifyApplication**. A Aplicação estará disponível através da
porta 8080. Ex: http://localhost:8080

Ao buildar a aplicação você poderá acessar a documentação Swagger disponível através do 
endereço: http://localhost:8080/swagger-ui.html

Para verificar e passar pelos testes unitários e de componente basta buildar o diretório **tests** pela IDE
ou rodar o comando de build do Gradle através do terminal: **gradlew clean build**


##Exemplo de chamada e retorno esperada

Exemplo de chamada com o CURL abaixo:

    curl --location --request POST 'http://localhost:8080/api/verify-pwd' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "password": "AbTp9!foF"
    }'

Exemplo do retorno esperado:

Retorno senha válida:

    {
        "isValid": true
    }

Retorno senha inválida:

    {
        "isValid": false
    }


##Observações finais

Essa é uma simples API de consulta e processamento a de strings, tentei fazer do jeito mais simples possível, utilizando
o Kotlin, tecnologia que ainda estou em aprendizado, para aprender e demonnstrar meus conhecimentos.

Nenhuma informação aqui trafegada possui criptografia nem ao menos é armazenada.

Esta aplicação é uma resposta ao exercício disponibilado pela empresa **Iti Itaú Digital**.


##Mais informações e referências

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

