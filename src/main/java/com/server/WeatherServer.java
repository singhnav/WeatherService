package com.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WeatherServer {

    private Server server;

    public void start() throws Exception {
        server = new Server(8080);

        String rootPath = WeatherServer.class.getClassLoader().getResource(".").toString();
        WebAppContext webapp = new WebAppContext(rootPath + "../../src/main/webapp", "");
        server.setHandler(webapp);


        server.start();
        server.join();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        new WeatherServer().start();
    }

}
