package com.example.eindopdracht.user;

import com.example.eindopdracht.reservation.Reservation;
import com.example.eindopdracht.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User  {


    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations = new HashSet<>();


    public Set<Role> getRoles() {
        return roles;
    }
    public Set<Role> setRoles() { return roles; }
}
