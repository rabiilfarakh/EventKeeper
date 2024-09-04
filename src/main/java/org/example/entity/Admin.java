package org.example.entity;

public class Admin extends User{

    private Integer adminId;


    public Admin() {
    }

    public Admin(Integer userId, String username, String password, Integer adminId) {
        super(userId, username, password);
        this.adminId = adminId;
    }

    @Override
    public Integer getId() {
        return adminId;
    }

    @Override
    public void setId(Integer adminId) {
        this.adminId = adminId;
    }
}
