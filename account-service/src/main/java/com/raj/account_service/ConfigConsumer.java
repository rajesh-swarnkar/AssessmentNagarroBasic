package com.raj.account_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigConsumer {

    @Value("${msg}")
    private String msg;

    @Value("${withdrawMSG}")

    // Getter methods
    public String getMsg() {
        return msg;
    }
}