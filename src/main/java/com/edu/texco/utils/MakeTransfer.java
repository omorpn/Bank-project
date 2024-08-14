package com.edu.texco.utils;

import com.edu.texco.model.account.Account;
import com.edu.texco.model.account.AccountType;
import com.edu.texco.model.account.Status;
import com.edu.texco.model.account.TransactionHistory;
import com.edu.texco.repository.AccountRepository;
import com.edu.texco.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MakeTransfer {
    private static final Double TRANSFER_CHARGES = 20.0;

    private final AccountRepository accountRepository;
    private final GenerateTransactionId generateTransactionId;
    private final TransactionRepository transactionRepository;

    public MakeTransfer(AccountRepository accountRepository, GenerateTransactionId generateTransactionId, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.generateTransactionId = generateTransactionId;
        this.transactionRepository = transactionRepository;
    }

    public Double checkBalance(String accountNumber) {
        Account account1 = accountRepository.findAccountByAccountNumber(accountNumber);
        return account1.getBalance();
    }
    public Status checkAccountStatus(String accountNumber) {
        Account account1 = accountRepository.findAccountByAccountNumber(accountNumber);
        return account1.getStatus();
    }
    public AccountType checkAccountType(String accountNumber) {
        Account account1 = accountRepository.findAccountByAccountNumber(accountNumber);
        return account1.getAccountType();
    }
    public String makeTransfer(String senderAccountNumber, Double amount ,String recieverAccountNumber) {
        Account senderAccount = accountRepository.findAccountByAccountNumber(senderAccountNumber);
        Account recieverAccount = accountRepository.findAccountByAccountNumber(recieverAccountNumber);

        double senderBalance = checkBalance(senderAccount.getAccountNumber());
        Double transferCharges= TRANSFER_CHARGES% amount;
        double totalAmount =amount + transferCharges;

        TransactionHistory history =TransactionHistory.builder()
                .receiver(recieverAccount.getAccountNumber())
                .sender(senderAccount.getAccountNumber())
                //.transactionAmount(amount.toString())
                //.transactionId(generateTransactionId.generateTransactionI())
                .transactionType("Credit")
                .transactionDate(LocalDateTime.now())
                .build();


        transactionRepository.save(history);
        if(totalAmount <= senderBalance) {
            if(checkAccountStatus(senderAccountNumber)==Status.ACTIVE){
            senderAccount.setBalance(senderBalance-totalAmount);
            recieverAccount.setBalance(recieverAccount.getBalance()+ amount);
            accountRepository.save(recieverAccount);
            accountRepository.save(senderAccount);
            history.setTransactionStatus("Successful");
                transactionRepository.save(history);
            return "Transfer of " +  amount.intValue() +" to "+recieverAccountNumber+" With account name "+ recieverAccount.getAccountName()+" is Successful";
            }else if(checkAccountStatus(recieverAccountNumber)==Status.BLOCKED){
                history.setTransactionStatus("Failed");
                transactionRepository.save(history);
                return  "Your account has been blocked";

            }else {
                history.setTransactionStatus("failed");
                transactionRepository.save(history);
                return "Your account is inactive";

            }
        }else {
            throw new RuntimeException("Low balance");
        }


    }

}
