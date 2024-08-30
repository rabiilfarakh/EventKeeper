package entity;

import enumeration.Role;

public class Admin extends User{
    public Admin(Long id, String username, String email, String password, Role role) {
        super(id, username, email, password,role);
    }
}
