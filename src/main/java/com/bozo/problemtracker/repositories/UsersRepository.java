package com.bozo.problemtracker.repositories;

import com.bozo.problemtracker.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findById(long id);
    Users findByName(String name);
}
