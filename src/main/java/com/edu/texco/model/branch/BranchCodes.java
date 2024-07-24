package com.edu.texco.model.branch;

import com.edu.texco.model.account.Address;
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
@Table(name = "branch_codes")
public class BranchCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String branchCode;
    @OneToOne
    private Branches branchName;
    @OneToOne
    private Address address;
}
