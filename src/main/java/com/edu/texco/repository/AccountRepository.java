package com.edu.texco.repository;

import com.edu.texco.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    boolean existsAccountByAccountNumber(String accountNumber);
    Account findAccountByAccountNumber(String accountNumber);
}
