package org.webapp.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webapp.bankingapp.entity.DiscountCard;
import org.webapp.bankingapp.exception.CardNotFoundException;
import org.webapp.bankingapp.repository.DiscountCardRepository;

import java.util.List;

@Service
public class DiscountCardServiceImpl implements DiscountCardService {

    @Autowired
    private DiscountCardRepository repository;

    @Override
    public List<DiscountCard> filter(boolean expired) {
        return repository.getExpiredCards(expired);
    }

    @Override
    public void setExpired(String id) {
        DiscountCard entity = getById(id);
        entity.setExpired(true);
        repository.save(entity);
    }

    @Override
    public List<DiscountCard> getAll() {
        return (List<DiscountCard>) repository.findAll();
    }

    @Override
    public DiscountCard create(DiscountCard discountCard) {
        return repository.save(discountCard);
    }

    @Override
    public DiscountCard getById(String id) {
        return repository.findById(id).orElseThrow(() -> new CardNotFoundException("Card with id " + id + "not found"));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
