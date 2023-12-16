package com.example.biz.cart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/insert")
    public ResponseEntity<?> test() {



        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }
}
