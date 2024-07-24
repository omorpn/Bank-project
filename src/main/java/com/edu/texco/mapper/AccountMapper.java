package com.edu.texco.mapper;

import com.edu.texco.dto.AccountDto;
import com.edu.texco.model.account.Account;
import com.edu.texco.model.account.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AccountMapper {

    public Account mapToAccountDto(AccountDto account) {

        return Account.builder()
                .username(account.getUsername())
                .accountType(account.getAccountType())
                .overdraftLimit(account.getOverdraftLimit())
                .lastTransactionDate(account.getLastTransactionDate())
                .interestRate(account.getInterestRate())
                .branchCode(account.getBranchCode())
                .identificationNumber(account.getIdentificationNumber())
                .dateCreated(LocalDateTime.now())
                .email(account.getEmail())
                .accountNumber(account.getAccountNumber())
                .accountName(account.getAccountName())
                .accountHolderAddress(account.getAccountHolderAddress())
                .phoneNumber(account.getPhoneNumber())
                .status(Status.ACTIVE)
                .balance(0.0)
                .password(account.getPassword())
                .build();

    }
    public AccountDto mapToAccount(Account accountDto){
      return AccountDto.builder()
                .username(accountDto.getUsername())
                .accountType(accountDto.getAccountType())
                .overdraftLimit(accountDto.getOverdraftLimit())
                .lastTransactionDate(accountDto.getLastTransactionDate())
                .interestRate(accountDto.getInterestRate())
                .branchCode(accountDto.getBranchCode())
                .identificationNumber(accountDto.getIdentificationNumber())
                .dateCreated(LocalDateTime.now())
                .email(accountDto.getEmail())
                .accountNumber(accountDto.getAccountNumber())
                .accountName(accountDto.getAccountName())
                .accountHolderAddress(accountDto.getAccountHolderAddress())
                .balance(accountDto.getBalance())
                .password(accountDto.getPassword())
                .build();

    }
}
