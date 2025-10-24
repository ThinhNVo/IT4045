package com.voti.databasemigration.repositories;

import com.voti.databasemigration.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
