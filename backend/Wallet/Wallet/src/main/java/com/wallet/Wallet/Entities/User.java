package com.wallet.Wallet.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    // Opérateur de la carte SIM (par exemple : IAM, Orange, Inwi)
    private String simOperator;
    // Indique si l'utilisateur est membre d'une banque !!!
    private boolean isBankMember;
    // Type de compte de l'utilisateur avec plafond
    private String accountType;
    // Titre de l'utilisateur (par exemple : M. ou Mme)
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String password;

}
