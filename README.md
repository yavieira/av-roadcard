# av-roadcard
Avaliação RoadCard

Estratégia de deploy da aplicação ( Tomcat )

Nessa branch, alterei o packaging da aplicação para 'war' e gerei o arquivo via Maven: 'mvn clean package'.  
    
Em seguida, com o Tomcat instalado, copiei o arquivo .war gerado para dentro da pasta /webapps do Tomcat.

Acesse a pasta /bin do tomcat via prompt de comando e execute:

Windows: catalina.bat run
Linux: catalina.sh run

Acesse via browser http://localhost:8080/app