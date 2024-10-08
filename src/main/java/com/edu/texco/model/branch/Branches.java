package com.edu.texco.model.branch;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "branches")
public class Branches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private BranchAddress branchAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private BranchCodes branchCodes;
    @Builder.Default
    private Double balance = 0.00;
    @Builder.Default
    private Double totalBalance = 0.00;
    @Builder.Default
    private Double allUsersBalance = 0.00;
}
