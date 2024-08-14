package com.edu.texco.mapper;

import com.edu.texco.model.account.TransactionHistory;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionHistory toTransaction() {
       return TransactionHistory.builder().build();
    }
}
