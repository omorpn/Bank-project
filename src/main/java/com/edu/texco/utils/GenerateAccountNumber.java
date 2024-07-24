package com.edu.texco.utils;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class GenerateAccountNumber {
    private static final int ACCOUNT_NUMBER_LENGTH = 10;
    private static final String ACCOUNT_NUMBER_REGEX = "4021";



    public static String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder(ACCOUNT_NUMBER_REGEX);
        Random rand = new Random();

        for(int i=0; i<ACCOUNT_NUMBER_LENGTH-ACCOUNT_NUMBER_REGEX.length(); i++) {
            accountNumber.append( rand.nextInt(10));
        }
//        if(accountNumber.length() > ACCOUNT_NUMBER_LENGTH) {
//            accountNumber.substring(0, ACCOUNT_NUMBER_LENGTH);
//        }
        return accountNumber.toString();
    }
}
