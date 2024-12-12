package org.webapp.bankingapp.service;

import org.webapp.bankingapp.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product findAllByTitle(String title);
}
