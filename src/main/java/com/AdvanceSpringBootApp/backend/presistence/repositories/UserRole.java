package com.AdvanceSpringBootApp.backend.presistence.repositories;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 22-Feb-17.
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {


    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;


    public UserRole() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (!user.equals(userRole.user)) return false;
        return role.equals(userRole.role);

    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
