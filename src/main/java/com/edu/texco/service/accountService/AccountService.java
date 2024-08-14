package com.edu.texco.service.accountService;

import com.edu.texco.dto.AccountDto;
import com.edu.texco.dto.CheckBalance;
import org.springframework.stereotype.Component;

@Component
public interface AccountService {
    AccountDto createAccount(AccountDto account);
    String makeTransfer(String from, String to, Double amount);

    String getBalance(CheckBalance accountNumber);
}
