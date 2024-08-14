package com.edu.texco.controllers;

import com.edu.texco.dto.AccountDto;
import com.edu.texco.dto.CheckBalance;
import com.edu.texco.dto.TransferDto;
import com.edu.texco.service.accountService.accountServiceImp.AccountServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/accounts")
@Validated
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
    @PostMapping("/transfer")
    public ResponseEntity<?> transferAccount(@RequestBody TransferDto transferDto) {
       String transfer = accountService.makeTransfer(transferDto.getFromAccount(),transferDto.getToAccount(),transferDto.getAmount());
        return new ResponseEntity<>(transfer,HttpStatus.CREATED);
    }
    @PostMapping("/balance")
    public ResponseEntity<?> checkAccountBalance(@Valid @RequestBody CheckBalance balance) {
        String balance1 = accountService.getBalance(balance);
      
        return new ResponseEntity<>(balance1,HttpStatus.CREATED);
    }
}
