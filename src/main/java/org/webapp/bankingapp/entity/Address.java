package org.webapp.bankingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id     // Cheia prima
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auro marire
    private Long id;

    private String fullAddress;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
