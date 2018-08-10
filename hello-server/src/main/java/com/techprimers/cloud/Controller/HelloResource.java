package com.techprimers.cloud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String hello() {
        return "Service2";
    }
}
