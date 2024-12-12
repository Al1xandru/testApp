package org.webapp.bankingapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.webapp.bankingapp.entity.DiscountCard;

import java.util.List;

@Repository
public interface DiscountCardRepository extends CrudRepository<DiscountCard, String> {

    @Query("SELECT card FROM DiscountCard card WHERE card.expired =:expired ")
    List<DiscountCard> getExpiredCards(boolean expired);
}
