package com.springws.demo.springwsvc;

import com.mycompany.loader.App;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting(){
        new App().count("We are the People who created cool Programs!");
        return "completed";
    }
}
