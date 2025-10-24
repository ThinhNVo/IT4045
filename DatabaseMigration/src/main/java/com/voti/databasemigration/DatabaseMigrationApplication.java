package com.voti.databasemigration;

import com.voti.databasemigration.entities.Address;
import com.voti.databasemigration.entities.Profile;
import com.voti.databasemigration.entities.User;


import com.voti.databasemigration.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.voti.databasemigration.repositories.UserRepository;

@SpringBootApplication
public class DatabaseMigrationApplication {

    public static void main(String[] args) {

        ApplicationContext context =  SpringApplication.run(DatabaseMigrationApplication.class, args);
        //var userRepository = context.getBean(UserRepository.class);
        var userService = context.getBean(UserService.class);
        //userService.showEntityState();
        userService.showRelatedEntities();
        /*var user1 = User.builder()
                .name("Jane smith")
                .email("smithJ@email.com")
                .password("243")
                .build();

         */

        /*
        //userRepository.deleteAll();
        //userRepository.save(user1);
        var user2 = userRepository.findById(2L).orElseThrow();
        //System.out.println(user2.getEmail());


        var users = userRepository.findAll();
        users.forEach(u -> System.out.println(u.getEmail()));


        var profile1 = Profile.builder()
                .bio("happy")
                .phoneNumber("9999999")
                .loyaltyPoints(0)
                .build();

        var address1= Address.builder()
                .id(1)
                .street("3206 riddle view")
                .city("cincinati")
                .state("Oh")
                .zip("45220")
                .build();

        var address2 = new Address(1,"3206 riddle view", "cincinati", "Oh", "45220", user1);
        user1.addProfile(profile1);
        user1.addAddress(address2);

*/

    }
}
