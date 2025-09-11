package com.voti.springnotificationservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringNotificationServiceApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringNotificationServiceApplication.class, args);

        var notificationManager = applicationContext.getBean(NotificationManager.class);
        notificationManager.sendNotification("Hello, this is a test message!");
    }

}
