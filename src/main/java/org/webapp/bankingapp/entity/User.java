package org.webapp.bankingapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.webapp.bankingapp.enums.Role;

import java.util.ArrayList;
import java.util.List;

@Entity     // Obiectele acestui class vor fi pastrate in BD
@Table(name = "shop_users")     //indicam numele tabelei de salvare
public class User {

    @Id     // Cheia prima
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auro marire
    private Long id;

    @NotNull
    @NotBlank
    private String login;
    private String password;

    @Email
    private String email;
    private String userInfo;  //user_info

    @Column(name = "description")
    private String information;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @OneToMany(cascade = CascadeType.ALL)
    //Aceasta column va fi creata in tablita Adreselor
    @JoinColumn(name = "user_id")
    private List<Address> addresses = new ArrayList<>();

    @OneToOne
    //Aceasta column va fi creata in tablita Users
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    //___________________________________________________________________________________________



    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
