package l.backenddemo.controller;

import l.backenddemo.utils.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String template = "Hello, %s!";

    @RequestMapping("/hello")
    public Greeting Hello(@RequestParam(value = "name", defaultValue = "World")String name){
        return new Greeting(String.format(template, name));
    }
}
