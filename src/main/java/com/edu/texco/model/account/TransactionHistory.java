package com.edu.texco.model.account;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="transaction_history")
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @Size(min = 16, max = 18)
    private String transactionId;
    private String transactionType;
    private LocalDateTime transactionDate;
    private String transactionAmount;
    private String sender;
    private String receiver;
    private String transactionStatus;
    private String transactionDescription;
}
