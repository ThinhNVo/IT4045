package com.voti.databasemigration.repositories;

import com.voti.databasemigration.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}