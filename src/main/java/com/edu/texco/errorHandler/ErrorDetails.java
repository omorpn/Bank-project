package com.edu.texco.errorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String error;
    private String message;

}
