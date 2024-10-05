package fr.chonchax;

import java.sql.Timestamp;

public class User {
    private int id;
    private String email;
    private String name;
    private String firstname;
    private Timestamp created_at;

    public User() {}

    public User(int id, String email, String name, String firstname, Timestamp created_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.firstname = firstname;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }
}
