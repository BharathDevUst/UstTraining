package com.demo.spring_rabbitmq_consumer_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomMessage {
    private String messageId;
    private String message;
    private Date messageDate;
}

