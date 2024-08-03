package com.example.userauthenticationmanagement.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record ErrorDetail(Date timeStamp, String message, String detail) {
}
