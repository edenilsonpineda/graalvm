package com.helidonwsvc.examples.se;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

import java.util.Optional;

public class GreetingChallengeService implements Service {
    @Override
    public void update(Routing.Rules rules) {
        rules
                .get("/", this::getDefaultMessageHanlder);
    }

    private void getDefaultMessageHanlder(ServerRequest serverRequest, ServerResponse serverResponse) {
        String response = "Hello All";
        Optional<String> val = serverRequest.queryParams().first("name");
        if(val.isPresent() && !val.get().isBlank()){
            response = response.replace("All", val.get());
        }

        serverResponse.send(response);
    }


}
