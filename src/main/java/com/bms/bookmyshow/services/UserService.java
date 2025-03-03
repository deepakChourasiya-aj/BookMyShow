package com.bms.bookmyshow.services;

import com.bms.bookmyshow.exceptions.UserNotFoundException;
import com.bms.bookmyshow.models.User;
import com.bms.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signup(String name, String email, String password){
        // 1. CHECK IF THE USER EXIT ALREADY IN
        // 2. IF NOT THEN CREATE THE USER OTHERWISE SAY ALREADY EXITS LOGIN DIRECTLY.

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    public User login(String email, String password) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with email: " + email + " is not found " );
        }
        User user = optionalUser.get();

        // COMPARE THE PASSWORD IF MATCHES THEN MAKE THE USER LOGGED IN..
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
           return user;
        }
        throw new RuntimeException("Wrong password");
    }
}
