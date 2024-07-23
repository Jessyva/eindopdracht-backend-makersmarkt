package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.model.Product;
import com.example.Makersmarkt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @lombok.Setter
    @lombok.Getter
    @Autowired
    public ProductService productService;
}

