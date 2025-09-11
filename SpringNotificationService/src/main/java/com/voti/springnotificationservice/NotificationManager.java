package com.voti.springnotificationservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    public final NotificationService notificationService;

    public NotificationManager(@Qualifier("sms") NotificationService notificationService) {this.notificationService = notificationService;}

    public void sendNotification(String message) {
        notificationService.send(message);
    }
}
