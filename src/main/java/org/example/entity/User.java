package org.example.entity;

public class User {

    private Integer userId;
    private String username;
    private String password;

    public User(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return userId;
    }

    public void setId(Integer userId) {
        this.userId = userId;
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

}
