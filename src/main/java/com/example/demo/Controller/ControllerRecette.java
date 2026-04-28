package com.example.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControllerRecette {


    @GetMapping("/tester1/{id}")
    public String tester(@PathVariable int id){
        System.out.println("hey hajhouj");
        return id+"";
    }
}
