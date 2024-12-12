package org.webapp.bankingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_cards")
public class DiscountCard {

    @Id     // Cheia prima
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean expired;


    public DiscountCard() {
        //
    }

    public DiscountCard(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
