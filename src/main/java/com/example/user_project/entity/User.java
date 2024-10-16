package com.example.user_project.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    @Transient
    private Integer age;
    private LocalDate dob;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Card> cards;
    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    private List<RoleEntity> roles;


    public User(String email, String name, LocalDate dob) {
        this.email = email;
        this.name = name;
        this.dob = dob;
    }

//    public User(String email, String name, Integer age, LocalDate dob, Set<RoleEntity> roles, List<Card> cards) {
//        this.email = email;
//        this.name = name;
//        this.age = age;
//        this.dob = dob;
//        this.cards = cards;
//        this.roles = roles;
//    }

    public User(String email, String name, LocalDate dob, List<RoleEntity> roles) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.roles = roles;
    }


    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}
