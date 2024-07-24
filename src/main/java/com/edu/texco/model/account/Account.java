package com.edu.texco.model.account;

import com.edu.texco.model.branch.BranchCodes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String accountName;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    @Builder.Default
    private Double balance= 0.0;
    @Column(nullable = false, unique = true)
    private String accountNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateCreated;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    private BranchCodes branchCode;
    private Double overdraftLimit;
    private Double interestRate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime lastTransactionDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Address accountHolderAddress;
    private String identificationNumber;
}
