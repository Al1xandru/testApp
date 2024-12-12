package org.webapp.bankingapp.service;

import org.webapp.bankingapp.entity.DiscountCard;

import java.util.List;

public interface DiscountCardService {

    List<DiscountCard> getAll();
    DiscountCard create(DiscountCard discountCard);
    DiscountCard getById(String id);
    void deleteById(String id);

    void setExpired(String id);

    List<DiscountCard> filter(boolean expired);

}
