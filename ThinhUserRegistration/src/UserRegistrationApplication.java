package com.voti.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserRegistrationApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(UserRegistrationApplication.class, args);
        var userService = context.getBean(UserService.class);

        if (userService.registerUser(new User(1L, "John Doe",  "jdoe@example.com", "password123"))
                & userService.registerUser(new User(2L, "John Doe", "jdoe@example.com", "password456"))) {
            System.out.println("\nUsers registered successfully");
        }
        else {
            System.out.println("\nUsers registered failed");
        }



    }

}
