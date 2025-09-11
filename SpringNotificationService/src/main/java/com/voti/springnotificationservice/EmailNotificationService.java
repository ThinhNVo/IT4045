package com.voti.springnotificationservice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Email: Sending Email: " + message);
    }
}
