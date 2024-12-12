package org.webapp.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webapp.bankingapp.entity.Product;
import org.webapp.bankingapp.exception.ProductNotFoundException;
import org.webapp.bankingapp.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findAllByTitle(String title) {
        Product entity = productRepository.findAllByTitle(title);
        if (entity == null) {
            throw new ProductNotFoundException("Product with title " + title + " not found");
        }
        return entity;
    }
}
