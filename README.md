# web-api-java
This is a reference application to impplement micro-services in Java.

### APIs
```
http://your-host-domain/api/v1/tasks
```
#### Methods available

- GET
- POST
- PUT
- DELETE

##Features Available
|Version | Description|
|:------:|------------|
| 0.0.1 | Core functionality added
|0.0.2 | Added Error Handling
|0.0.3 | Enabled CORS


### Docker Buiild
```
docker build . -t web-api-java:latest
```

### Start Tomcat Container Server
```
docker run  --publish 8080:8080 --detach --volume ~/tomcat_home:/user/local/tomcat --name tomcat web-api-java:latest
```
### API URI
```
http://your-host-ip:8080/web-api-java-0.0.3/api/v1/tasks
```
