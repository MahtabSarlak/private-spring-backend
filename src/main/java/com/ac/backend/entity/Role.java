package com.ac.backend.entity;

import com.ac.backend.annotaion.ValidRoleName;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ac.backend.annotaion.ValidRoleName;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Keno&Kemo on 04.11.2017..
 */
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ValidRoleName
    @Column(unique = true)
    private String name;

    @JsonManagedReference
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }
}
