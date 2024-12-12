package org.webapp.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.webapp.bankingapp.entity.Product;
import org.webapp.bankingapp.entity.User;
import org.webapp.bankingapp.exception.ProductNotFoundException;
import org.webapp.bankingapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAll();
    }

    @GetMapping("/{title}")
    public Product getByTitle(@PathVariable String title) {
        return productService.findAllByTitle(title);
    }

}
