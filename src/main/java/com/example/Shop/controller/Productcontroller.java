package com.example.Shop.controller;

import com.example.Shop.dtos.reqdtos.Productreqdtos;
import com.example.Shop.dtos.respodtos.ProductRespodtos;
import com.example.Shop.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class Productcontroller {

    @Autowired
    Productservice productservice;

    @PostMapping("/add-product")
    public String addproduct(@RequestBody Productreqdtos productreqdtos){
        try {
            String response = productservice.addproduct(productreqdtos);
            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/add-quantity")
    public Object updatequantity(@RequestParam("id") String name , @RequestParam("q") int quantity){
        try {
            ProductRespodtos productRespodtos = productservice.updatequantity(name,quantity);
            return productRespodtos;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/delete-quantity")
    public Object deletequantity(@RequestParam("id") String name , @RequestParam("q") int quantity){
        try {
            ProductRespodtos productRespodtos = productservice.deletequantity(name,quantity);
            return productRespodtos;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }



}
