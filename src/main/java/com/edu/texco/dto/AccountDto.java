package com.edu.texco.dto;

import com.edu.texco.model.account.AccountType;
import com.edu.texco.model.account.Address;
import com.edu.texco.model.account.Status;
import com.edu.texco.model.branch.BranchCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private String accountName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Double balance;
    private String accountNumber;
    private AccountType accountType;
    private LocalDateTime dateCreated;
    private Status status;

    private BranchCodes branchCode;
    private Double overdraftLimit;
    private Double interestRate;
    private LocalDateTime lastTransactionDate;
    private Address accountHolderAddress;
    private String identificationNumber;
}
