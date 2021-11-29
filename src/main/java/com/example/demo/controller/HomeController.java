package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final Environment environment;

    @Autowired
    public HomeController(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("/")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok("order-ws is up and running on port: "+environment.getProperty("local.server.port"));
    }
}
