package com.lsis.sjleea.sjleeaApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private String helloMessage;

    public HelloController(@Value("${hello.message}") String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @GetMapping("/")
    public String sayHello() {
        return helloMessage;
    }
}
