package com.hdsvc;

import com.mycompany.loader.App;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class ExampleService implements Service {

    @Override
    public void update(Routing.Rules rules) {
        rules
            .get("/", this::getDefaultMessageHandler);
    }

    private void getDefaultMessageHandler(ServerRequest request, ServerResponse response) {
        new App().count("We the people of El Salvador in Central America!");
        response.send("It works!");
    }
}
