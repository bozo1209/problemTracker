package com.bozo.problemtracker.security;

import com.bozo.problemtracker.entities.Users;
import com.bozo.problemtracker.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private UsersRepository usersRepository;

    @Autowired
    public ApplicationUserDetailsService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByName(username);
        if (users == null){
            throw new UsernameNotFoundException(username);
        }
        return new ApplicationUser(users);
    }
}
