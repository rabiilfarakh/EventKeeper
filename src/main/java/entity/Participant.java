package entity;

import enumeration.Role;

public class Participant extends User {

    private Long id;
    private String phone;

    public Participant() {
        super();
    }

    public Participant(Long id, String username, String email, String password, String phone) {
        super(id, username, email, password, Role.PARTICIPANT);
        this.phone = phone;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}