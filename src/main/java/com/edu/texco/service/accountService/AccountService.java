package com.edu.texco.service.accountService;

import com.edu.texco.dto.AccountDto;
import org.springframework.stereotype.Component;

@Component
public interface AccountService {
    AccountDto createAccount(AccountDto account);

}
