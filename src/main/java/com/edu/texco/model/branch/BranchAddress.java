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
@Table(name = "branch_address")
public class BranchAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    private Branches branches;
    private Long id;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}
