package com.voti.databasemigration.repositories;

import com.voti.databasemigration.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}