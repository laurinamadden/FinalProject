package com.mydomain.myproject.services;// Spring Initializr

//import org.hibernate.annotations.processing.Find;// Auto created by VS Code
import org.springframework.http.HttpStatus;// Auto created by VS Code
import org.springframework.stereotype.Service;// Auto created by VS Code
import org.springframework.web.server.ResponseStatusException;// Auto created by VS Code

//import org.springframework.http.HttpStatus; //Thought this was needed but VS doesnt like it

import com.mydomain.myproject.entities.User;
import com.mydomain.myproject.repositories.UserRepository;

@Service
public class UserService {// Spring Initializr
    
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    /*
    //Returns true or false 
    public boolean usernameExists (String username){
        return userRepository.existsByUsername(username);
    }

    //Returns User object
    public User findUser(String username){
        return userRepository.findByUsername(username);
    }
    */
    //Checks if username exists. If true returns the user object if false not found message is returned.
    public User findUser(String username) {
        if (userRepository.existsByUsername(username)) {
            return userRepository.findByUsername(username);
        } 
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username doesn't exist. Please try again.");
        }
    }


}// Spring Initializr
