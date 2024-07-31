package com.example.userauthenticationmanagement.dto;

import java.util.Date;

public record ErrorDetail(Date timeStamp, String message, String detail) {
}
