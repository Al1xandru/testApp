package org.webapp.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webapp.bankingapp.entity.Address;
import org.webapp.bankingapp.service.UserService;

@RestController
@RequestMapping("/api/addresses")
public class AdressController {

    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public Address getByUserId() {
        Long currentUserName = userService.getCurrentUserId();
        return null;
    }
}
