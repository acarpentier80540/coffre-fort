package com.wildcodeschool.coffreFort.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false) 
    private String password;
  
    @OneToMany(mappedBy = "user")
    private List<Safe> safes;

    public User() {  }

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public User(Long id, String username, String password) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Safe> getSafes() { return safes; }

    public void setSafe(List<Safe> safes) { this.safes = safes; }
}

