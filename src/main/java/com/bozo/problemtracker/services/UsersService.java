package com.bozo.problemtracker.services;

import com.bozo.problemtracker.entities.Users;
import com.bozo.problemtracker.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users getUsersById(long id){
        return usersRepository.findById(id);
    }

    public Users getUsersByName(String name){
        return usersRepository.findByName(name);
    }
}
