package com.edu.texco.service.accountService.accountServiceImp;

import com.edu.texco.dto.AccountDto;
import com.edu.texco.mapper.AccountMapper;
import com.edu.texco.model.account.Account;
import com.edu.texco.repository.AccountRepository;
import com.edu.texco.service.accountService.AccountService;
import org.springframework.stereotype.Service;

import static com.edu.texco.utils.GenerateAccountNumber.generateAccountNumber;
@Service
public class AccountServiceImp implements AccountService {
    private final AccountMapper accountMapper;
    private  final AccountRepository accountRepository;

    public AccountServiceImp( AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto account) {

        Account anAccount = accountMapper.mapToAccountDto(account);
        anAccount.setAccountNumber(generateAccount());
        Account account1 =accountRepository.save(anAccount);
        return accountMapper.mapToAccount(account1);
    }
    private String generateAccount() {
        String accountNumber;
        boolean exists;
        do {
            accountNumber= generateAccountNumber();
            exists = accountRepository.existsAccountByAccountNumber(accountNumber);
        }while(exists);
        return accountNumber;
    }

}
