package com.rajni.userservice.exception.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class ErrorModel {
    private String errorCode;
    private String errorMessage;
}
