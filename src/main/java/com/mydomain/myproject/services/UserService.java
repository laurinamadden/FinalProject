package com.mydomain.myproject.services;// Spring Initializr

//import org.hibernate.annotations.processing.Find;// Auto created by VS Code
import org.springframework.http.HttpStatus;// Auto created by VS Code
import org.springframework.stereotype.Service;// Auto created by VS Code
import org.springframework.web.server.ResponseStatusException;// Auto created by VS Code

//import org.springframework.http.HttpStatus; //Thought this was needed but VS doesnt like it

import com.mydomain.myproject.entities.User;
//import com.mydomain.myproject.entities.LogIn;
import com.mydomain.myproject.repositories.UserRepository;

import java.util.HashMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
// Update to BCrypt when get a chance - thats what codecademy AI says is best practice for passwords
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {// Spring Initializr
    
    //Declares field to hold the repository 
    private final UserRepository userRepository;

    //The constructor 
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

    // User user = userRepository.findByUsername(username);

    //Hash 
    //Creates new HashMap to store stuff
    private HashMap<String, String> user = new HashMap<>();

    // Hash password
    //Method to help write hash passwords
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        //SHA-256 is a 32-byte hash value hashing algorithm
        MessageDigest hashP = MessageDigest.getInstance("SHA-256");
        byte[] hash = hashP.digest(password.getBytes());
        StringBuilder hexadecimalString = new StringBuilder();
        // %02x - format specifier code to format founction tells program how to display the value
        // % starts it off, 0 says add 0 if needed, 2 says width 2 char and x says show value with base 16(hexadecimal)
        for (byte b : hash) hexadecimalString.append(String.format("%02x", b));
        return hexadecimalString.toString();
    }

    // Register user
    //Method to add registered user to the HashMap
    public void registerH(String username, String password) throws NoSuchAlgorithmException {
        user.put(username, hashPassword(password));
    }

    // Login
    //Method to see if username an password match the HashMap 
    public boolean loginH(String username, String password) throws NoSuchAlgorithmException {
        String passwordH = user.get(username);
        if (passwordH == null) return false;
        return passwordH.equals(hashPassword(password));
    }





}// Spring Initializr
