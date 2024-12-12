package org.webapp.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.webapp.bankingapp.entity.User;

import java.util.List;

@Repository
public interface UsersJpaRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    List<User> findAllByPassword(String password);

    @Query("SELECT u FROM User u WHERE u.userInfo IS NOT NULL")
    List<User> getUserWithUserInfo();
}
