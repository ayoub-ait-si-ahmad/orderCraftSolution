package com.orderCraftSpringApp.model.classes;

import com.orderCraftSpringApp.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserID")
    private Long UserID;

    @Column(name="UserName" ,unique = true, nullable = false)
    private String UserName;

    @Column(name="firstName" , nullable = false)
    private String firstName;

    @Column(name="lastName" , nullable = false)
    private String lastName;

    @Column(name="email" , nullable = false)
    private String email;

    @Column(name="password" , nullable = false)
    private String password;

    @Column(name="role" , nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.CLIENT;
}