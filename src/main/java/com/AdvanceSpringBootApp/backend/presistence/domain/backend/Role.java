package com.AdvanceSpringBootApp.backend.presistence.domain.backend;

import com.AdvanceSpringBootApp.enums.RolesEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 22-Feb-17.
 */
@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private java.util.Set<UserRole> userRoles = new HashSet<>();

    public Role() {
    }

    public Role(RolesEnum rolesEnum) {

        this.id = rolesEnum.getId();
        this.name = rolesEnum.getRoleName();
    }


    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return id == role.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
