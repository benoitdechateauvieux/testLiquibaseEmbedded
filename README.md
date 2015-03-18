Test Liquibase as a Servlet Listener embedded in a Servlet/Maven/Tomcat project

## Option #1: Gesnerating SQL script
mvn liquibase:updateSQL
generates the script for DBA

## Option #2: Running the App
mvn tomcat7:run
Run the app (LiquibaseServletListener will automatically apply changes to database)

## Option #3: Testing with Liquibase Java API
http://localhost:8080/testliquibase/updateDB
