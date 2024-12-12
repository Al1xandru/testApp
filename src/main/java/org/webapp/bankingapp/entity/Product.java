package org.webapp.bankingapp.entity;

import jakarta.persistence.*;
import org.webapp.bankingapp.enums.ProductType;

@Entity
@Table(name = "shop_products")
public class Product {
    @Id     // Cheia prima
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
    public Product() {
        //
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public ProductType getType() {
        return type;
    }
    public void setType(ProductType type) {
        this.type = type;
    }
}
