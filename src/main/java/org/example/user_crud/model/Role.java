package org.example.user_crud.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String role;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "roles")
    private Collection<User> users;

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return role;
    }

    public void setName(String name) {
        this.role = name;
    }


    @Override
    public String getAuthority() {
        return role;
    }
}
