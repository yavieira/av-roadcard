# av-roadcard
Avaliação RoadCard

Prezados, primeiramente obrigado pela oportunidade.

Expresso aqui também minha genuína vontade de atuar com vocês nesse projeto. Vejo como uma oportunidade ímpar pra minha carreira.

Vamos ao que interessa :)

Para realizar a subida local siga as instruções:

1: Faça o download do projeto 

 1.1: Via Git -> Faça o download do git no site https://git-scm.com/downloads
                 Instale o arquivo baixado na sua máquina (next next finish)
                 Clique com botão direito em uma pasta e selecione Git Bash
                 Dentro do terminal, execute o comando 'git clone https://github.com/yavieira/av-roadcard.git'
 
 1.2: Via Browser -> Clique no botão verde 'Clone or download' e selecione a opção 'Download ZIP'
                     Extraia o arquivo ZIP em uma pasta de sua preferência                 
                     
 2: Para evitar a necessidade do Maven instalado, disponibilizei o jar da aplicação na pasta raíz. Abrir o prompt de comando ou git bash na pasta do projeto e digitar o comando 'java -jar app-0.0.1-SNAPSHOT.jar'
 
 3: Para testar a aplicação local:
  
  3.1: Via Postman -> A collection está disponibilizada no projeto, basta importar no Postman. Import > Choose File.
  
  3.2: Via Curl -> Para facilitar, vou disponibilizar um exemplo de curl pra cada endpoint da aplicação.
  
    lista -> curl -X GET http://localhost:8080/usuario
    findByCpfOrName -> 'curl -X GET http://localhost:8080/usuario/buscaPorCpfOuNome/Yuri%20Iagi' (%20 representa espaço em branco)
                       'curl -X GET http://localhost:8080/usuario/buscaPorCpfOuNome/14611835707'
    atualizar -> 'curl -X PUT -H "Content-Type: application/json" -d "{"""nome""":"""Teste""","""cpf""": """123"""}" http://localhost:8080/usuario/1' (os double quotes só funcionam assim no meu prompt, caso tenha problemas executando dessa forma verifique: https://mkyong.com/web/curl-put-request-examples/)
    remover -> 'curl -X DELETE http://localhost:8080/usuario/1'
    cadastrar -> 'curl -H "Content-Type: application/json" -X POST -d "{\"nome\":\"Av RoadCard\",\"cpf\":\"13345678909\"}" http://localhost:8080/usuario/'

4: Estratégia de deploy da aplicação na branch 'deploy'
