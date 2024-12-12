package org.webapp.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.webapp.bankingapp.entity.DiscountCard;
import org.webapp.bankingapp.service.DiscountCardService;
import java.util.List;

@RestController
@RequestMapping("/api/discountcards")
public class DiscountCardController {

    @Autowired
    private DiscountCardService cardService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<DiscountCard> getAll() {
        return cardService.getAll();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public DiscountCard getById(@PathVariable(name = "id") String id) {
        return cardService.getById(id);
    }

    @PostMapping
    public DiscountCard create(@RequestBody DiscountCard card) {

        return cardService.create(card);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String cardId){
        cardService.deleteById(cardId);
    }

    @PostMapping("/expired/{id}")
    public void setExpired(@PathVariable String id){
        cardService.setExpired(id);
    }

    @GetMapping("/filter")
    public List<DiscountCard> getAllByState(@RequestParam(name = "expired") boolean expired) {
        return cardService.filter(expired);
    }
}
