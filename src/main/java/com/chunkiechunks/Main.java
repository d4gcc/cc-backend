package com.chunkiechunks;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import java.sql.SQLException;

@QuarkusMain
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    static Server server;

    public static void main(String[] args) throws SQLException {
        System.out.println("Starting up the application...");
        log.info("TCP server starting....");
        server = Server.createTcpServer("-tcpPort", "9002", "-tcpAllowOthers").start();
        Quarkus.run(args);
    }

    void onStop(@Observes ShutdownEvent event) {
        log.info("TCP server stopping....");
        server.stop();
    }
}
