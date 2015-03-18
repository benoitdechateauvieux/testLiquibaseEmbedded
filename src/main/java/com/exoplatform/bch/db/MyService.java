package com.exoplatform.bch.db;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.Connection;

/**
 * Created by bdechateauvieux on 3/18/15.
 */
@Path("/")
public class MyService {

    @GET
    @Path("/updateDB")
    public void updateBD() {
        String changeLog = "com/example/db/changelog/db.changelog-master.xml";
        try {
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(getJNDIConnection()));
            Liquibase liquibase = new Liquibase(changeLog, new ClassLoaderResourceAccessor(), database);
            liquibase.update((String)null);
        } catch (LiquibaseException e) {
            e.printStackTrace();
        }
    }

    private Connection getJNDIConnection(){
        Connection result = null;
        try {
            Context initialContext = new InitialContext();
            DataSource datasource = (DataSource)initialContext.lookup("java:comp/env/jdbc/default");
            return datasource.getConnection();
        }
        catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return result;
    }
}
