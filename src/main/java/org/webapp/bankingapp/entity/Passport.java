package org.webapp.bankingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passports")
public class Passport {

    @Id     // Cheia prima
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auro marire
    private Long id;

    private String number;

    public Passport() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
