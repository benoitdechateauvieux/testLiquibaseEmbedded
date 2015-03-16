# testLiquibaseEmbedded
Test Liquibase as a Servlet Listener embedded in a Servlet/Maven/Tomcat project

mvn liquibase:updateSQL
generates the script for DBA

mvn tomcat7:run
Run the app (LiquibaseServletListener will automatically apply changes to database)
