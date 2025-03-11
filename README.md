1. after run the application run : http://localhost:8088/graphiql?operationName=allBooks
2. do access the consul UI : http://localhost:8500/ui
3. make eclipse maven to use our installed java jdk
   ->Windows->prefernce->java->installed JRE
   add the path of our jdk: C:\ Program Files\Java\jdk1.8.0_202\jre
   then check that checkbox 

4. basic needed dependcies for write Restapi
    spring web -includes Restful, embeeded tomcat server
   Lombok - annotation for reduce the boilerplate code
   Mysql Driver - for database connnection
   spring consul config- for spring confiuration
   spring consul discovery - to register any microservice to an consul
   spring for graphql - for use graphQl
   H2 database - just a embedded database
   spring reactive web - alternative for spring web to enable like webflux and netty server
  spring R2DBC- reactive repository for the spring web flux to achieve reactive programming in spring boot to handle multiple request and enable non blocking I/O operations
