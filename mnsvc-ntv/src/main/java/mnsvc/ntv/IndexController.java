package mnsvc.ntv;

import com.mycompany.loader.App;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;

@Controller("/example")
public class IndexController {
    @Get(produces = MediaType.TEXT_PLAIN)
    public String getExample(){
        String text = "We the people of the United States of America";
        App app = new App();
        app.count(text);

        return "Completed";
    }

    /**
     * @QueryValue(defaultValue = "Hello World")  can be another way to provide the query param.
     * @param name
     * @return
     */
    @Get(produces = MediaType.TEXT_PLAIN, uri = "/greeting{?name}")
    public String greeting(@Nullable String name){
        if(name == null || name.isBlank()){
            return "Hello All";
        }
        return "Hello " + name;
    }
}
