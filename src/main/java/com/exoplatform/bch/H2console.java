package com.exoplatform.bch;

import org.h2.tools.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

/**
 * Created by bdechateauvieux on 3/16/15.
 */
@WebListener
public class H2console implements ServletContextListener {
    private Server webServer;

    public void contextInitialized(ServletContextEvent event) {
        try {
            System.out.println("H2 Web server - starting");
            webServer = Server.createWebServer("-webAllowOthers", "-webPort", "8082").start();
            System.out.println("H2 Web server - started");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Server server = Server.createTcpServer("-tcpAllowOthers","-tcpPort","9092").start();
    }

    public void contextDestroyed(ServletContextEvent event) {
        webServer.stop();
    }
}
