package com.edu.texco.repository;

import com.edu.texco.model.account.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionHistory, Long> {
    Boolean existsByTransactionId(String transactionId);
}
