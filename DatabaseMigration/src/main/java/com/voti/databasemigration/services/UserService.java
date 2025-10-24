package com.voti.databasemigration.services;

import com.voti.databasemigration.repositories.ProfileRepository;
import com.voti.databasemigration.repositories.UserRepository;
import com.voti.databasemigration.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service

public class UserService {

    private final UserRepository userRepository;
    private final EntityManager em;
    private final ProfileRepository pr;

    @Transactional
    public void showEntityState() {

        var users = User.builder()
                .name("James")
                .email("123@gmail.com")
                .password("passowrd")
                .build();

        if(em.contains(users))
        {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient/Detached");
        }

        userRepository.save(users);

        if(em.contains(users))
        {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient/Detached");
        }
    }

    @Transactional
    public void showRelatedEntities() {
        //var user = userRepository.findById(3L).orElseThrow();
        //System.out.println(user.getEmail());

        var profile = pr.findById(3).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void deleteReleated() {

    }
}
