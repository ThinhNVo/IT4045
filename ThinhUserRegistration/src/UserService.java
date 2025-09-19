package com.voti.userregistration;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public boolean registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("\nThis email already exists");
            return false;
        }

        userRepository.save(user);
        notificationService.send("successfully registered, sending notification email", user.getEmail());
        return true;
    }
}
