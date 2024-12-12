package org.webapp.bankingapp.service;

import org.webapp.bankingapp.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(Long id);
    User create(User user);
    User getByName(String name);
    List<User> getWithEqualsPasswords(String password);
    void delete(Long id);
    String getCurrentUserName();
    Long getCurrentUserId();


}
