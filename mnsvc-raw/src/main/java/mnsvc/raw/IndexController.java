package mnsvc.raw;

import com.mycompany.loader.App;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/example")
public class IndexController {
    @Get(produces = MediaType.TEXT_PLAIN)
    public String getExample(){
        String text = "We the people of the United States of America";
        App app = new App();
        app.count(text);

        return "Completed";
    }
}
