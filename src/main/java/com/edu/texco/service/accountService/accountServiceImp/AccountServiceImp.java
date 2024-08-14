package com.edu.texco.service.accountService.accountServiceImp;

import com.edu.texco.dto.AccountDto;
import com.edu.texco.dto.CheckBalance;
import com.edu.texco.mapper.AccountMapper;
import com.edu.texco.model.account.Account;
import com.edu.texco.repository.AccountRepository;
import com.edu.texco.repository.TransactionRepository;
import com.edu.texco.service.accountService.AccountService;
import com.edu.texco.utils.MakeTransfer;
import org.springframework.stereotype.Service;

import static com.edu.texco.utils.GenerateAccountNumber.generateAccountNumber;
@Service
public class AccountServiceImp implements AccountService {
    private final AccountMapper accountMapper;
    private  final AccountRepository accountRepository;
    public final MakeTransfer makeTransfer;
    private final TransactionRepository transactionRepository;

    public AccountServiceImp(AccountMapper accountMapper, AccountRepository accountRepository, MakeTransfer makeTransfer, TransactionRepository transactionRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
        this.makeTransfer = makeTransfer;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto account) {

        Account anAccount = accountMapper.mapToAccountDto(account);
        anAccount.setAccountNumber(generateAccount());
        Account account1 =accountRepository.save(anAccount);
        return accountMapper.mapToAccount(account1);
    }

    @Override
    public String makeTransfer(String from, String to, Double amount) {
        return makeTransfer.makeTransfer(from,amount,to);
    }



    @Override
    public String getBalance(CheckBalance balance) {
        try {
            Account balance1 = accountRepository.findAccountByAccountNumber(balance.getAccountNumber());

            if (balance1.getPin() != null) {
                if (balance1.getPin().contentEquals(balance.getPin())) {
                    return "Your Available Balance is " + balance1.getBalance();
                } else {
                    return "Incorrect Pin ";
                }

            } else {
                return "No pin Set";
            }
        }catch (Exception e){
            String n = new String(e.getMessage());
            String g = new String("e.getMessage()");
            boolean t;
            t = g == n;
            Thread  y = new Thread(n);


            return String.valueOf(y.threadId());
        }
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
