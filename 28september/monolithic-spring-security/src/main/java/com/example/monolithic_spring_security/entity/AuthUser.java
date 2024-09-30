package com.example.monolithic_spring_security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "user_details")
public class AuthUser {
    @Id
    @Column(name = "cred_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authUserId;

    @Column(name = "cred_username")
    private String authUserName;

    @Column(name = "cred_password")
    private String authUserPwd;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "credential_role", joinColumns = @JoinColumn(name = "cred_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Roles> allRoles;
}
