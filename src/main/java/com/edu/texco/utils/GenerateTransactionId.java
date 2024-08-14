package com.edu.texco.utils;

import com.edu.texco.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateTransactionId {
        private final TransactionRepository transactionRepository;
        private static final String TRANSACTION_ID="";
        private static final int TRANSACTION_ID_LENGTH=32;

    public GenerateTransactionId(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public String generateTransactionI() {
        StringBuilder builder=new StringBuilder(TRANSACTION_ID);
        Random random=new Random();
        boolean exists;
        do {
            for(int i=0;i<TRANSACTION_ID_LENGTH-TRANSACTION_ID.length();i++){
                builder.append(random.nextInt(10));

            }
            exists=transactionRepository.existsByTransactionId(String.valueOf(builder));

        }while(exists);


        return builder.toString();
    }
}
