package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @PostMapping
    public ResponseEntity<Chocolate> NewChocolate(@RequestBody Chocolate chocolate){
        Chocolate savedChocolate = chocolateService.saveChocolate(chocolate);
        return new ResponseEntity<>(savedChocolate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolate(){
        List<Chocolate> chocolates = chocolateService.getAllChocolate();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }


}
