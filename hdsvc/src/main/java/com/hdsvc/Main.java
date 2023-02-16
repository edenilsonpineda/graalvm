package com.hdsvc;

import java.io.IOException;

import io.helidon.config.Config;
import io.helidon.media.jsonp.server.JsonSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

/**
 * The application main class.
 */
public final class Main {

    /**
     * Cannot be instantiated.
     */
    private Main() { }

    /**
     * Application main entry point.
     * @param args command line arguments.
     * @throws IOException if there are problems reading logging properties
     */
    public static void main(final String[] args) throws IOException {
        startServer();
    }

    /**
     * Start the server.
     * @return the created {@link WebServer} instance
     * @throws IOException if there are problems reading logging properties
     */
    static WebServer startServer() throws IOException {

        // By default this will pick up application.yaml from the classpath
        Config config = Config.create();

        // Get webserver config from the "server" section of application.yaml
        ServerConfiguration serverConfig =
                ServerConfiguration.create(config.get("server"));

        WebServer server = WebServer.create(serverConfig, createRouting(config));
        // Try to start the server. If successful, print some info and arrange to
        // print a message at shutdown. If unsuccessful, print the exception.
        server.start()
            .thenAccept(ws -> {
                System.out.println("WEB server is up! http://localhost:" + ws.port() + "/example");
                ws.whenShutdown().thenRun(()
                    -> System.out.println("WEB server is DOWN. Good bye!"));
                })
            .exceptionally(t -> {
                System.err.println("Startup failed: " + t.getMessage());
                t.printStackTrace(System.err);
                return null;
            });

        // Server threads are not daemon. No need to block. Just react.
        return server;
    }

    /**
     * Creates new {@link Routing}.
     *
     * @return configured routing
     * @param config configuration of this server
     */
    private static Routing createRouting(Config config) {

        return Routing.builder()
                .register(JsonSupport.create())
                .register("/example", new ExampleService())
                .build();
    }
}
