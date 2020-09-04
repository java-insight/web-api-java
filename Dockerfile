FROM kpjyothish/tomcat:latest
MAINTAINER JKP "kp.jyothish@gmail.com"
ADD target/web-api-java-*.war /usr/local/tomcat/webapps/
RUN apt-get update
EXPOSE 8080
CMD ["catalina.sh","run"]