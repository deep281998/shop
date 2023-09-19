package com.example.Shop.controller;

import com.example.Shop.service.Companyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class Companycontroller {


    @Autowired
    Companyservice companyservice;

    @PostMapping("/add-company")
    public String addcompany(@RequestParam("name") String name){
        try {
            String response = companyservice.addcompany(name);
            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
