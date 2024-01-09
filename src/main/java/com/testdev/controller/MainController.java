package com.testdev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/main")
public class MainController {

    @GetMapping(path = "/hello" , produces = "application/json")
    public String getHello(){
        return "Hello All";
    }

    // Pour admin
    @GetMapping(path = "/protected" , produces = "application/json")
    public String getProtected(){
        return "Access sur Protected";
    }
    
    // All
    @GetMapping(path = "/public" , produces = "application/json")
    public String getPublic(){
        return "Access sur Public";
    }

    // User
    @GetMapping(path = "/user" , produces = "application/json")
    public String getUser(){
        return "Access sur utilisateur";
    }
}
