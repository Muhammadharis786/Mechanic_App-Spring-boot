package com.haris.MechanicApp.Model.Verification;

import jakarta.persistence.*;


@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid ;

    private String password;
    private String email ;
    private String username;

    @Column(name = "enable")
    private boolean enabled=false;

    @Column(name = "registration_date")
    private String registrationDate;

    private String role= "User";

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String password, String email ) {


        this.password = password;
        this.email = email;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User() {

    }

    public long getId() {
        return userid;
    }

    public void setId(long id) {
        this.userid = id;
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
}
