package org.webapp.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webapp.bankingapp.entity.User;
import org.webapp.bankingapp.exception.UserNotFoundException;
import org.webapp.bankingapp.repository.UsersJpaRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersJpaRepository jpaRepository;

    @Override
    public List<User> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return jpaRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user with id " + id + " not found"));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<User> getWithEqualsPasswords(String password) {
        return jpaRepository.findAllByPassword(password);
    }

    @Override
    public User getByName(String name) {
        return jpaRepository.findByLogin(name);
    }

    @Override
    public User create(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication != null) ? authentication.getName() : null;
    }

    @Override
    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication != null) ? getByName(authentication.getName()).getId() : null;
    }
}
