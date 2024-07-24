package com.edu.texco.controllers;

import com.edu.texco.dto.AccountDto;
import com.edu.texco.service.accountService.accountServiceImp.AccountServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountServiceImp accountService;

    public AccountController(AccountServiceImp accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> getAccountService(@RequestBody AccountDto accountDto) {
        AccountDto accountDto1 =accountService.createAccount(accountDto);
        return new ResponseEntity<>(accountDto1, HttpStatus.CREATED);

    }
}
