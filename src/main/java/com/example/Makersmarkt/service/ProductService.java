package com.example.Makersmarkt.service;
import com.example.Makersmarkt.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private Object id;
    private Object name;
    private Object description;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
            this.id = id;
            this.name = name;
            this.description = description;
        // Voeg hier je logica toe om producten op te halen
        return products;
    }
}
