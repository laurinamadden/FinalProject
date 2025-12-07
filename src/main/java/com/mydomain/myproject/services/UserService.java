package com.mydomain.myproject.services;// Spring Initializr

//import static org.junit.jupiter.api.Assertions.assertTrue;// Auto created by VS Code but didn't like it after changed to 4.0.0 apparently its only for test classes

//import org.hibernate.annotations.processing.Find;// Auto created by VS Code
import org.springframework.http.HttpStatus;// Auto created by VS Code
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;// Auto created by VS Code
import org.springframework.web.server.ResponseStatusException;// Auto created by VS Code
// Update to BCrypt when get a chance - thats what codecademy AI says is best practice for passwords
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import org.springframework.http.HttpStatus; //Thought this was needed but VS doesnt like it

import com.mydomain.myproject.entities.User;
//import com.mydomain.myproject.entities.LogIn;
import com.mydomain.myproject.repositories.UserRepository;

//import java.util.HashMap;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;


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
    // Part of log in not register
    public User findUser(String username) {
        if (userRepository.existsByUsername(username)) {
            return userRepository.findByUsername(username);
        } 
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username doesn't exist. Please try again.");
        }
    }

    // User user = userRepository.findByUsername(username);
    /*
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
    */
    // Pre Register Process?



    // Register Process 
    public ResponseEntity<?> regUser(User user) {
        boolean check1 = false;
        boolean check2 = false;

        for(int i = 0; i < user.getUsername().length(); i++){
            //
            char check = user.getUsername().charAt(i);
            // 
            if(0==0) {
                check1 = true;
            }
            if(0==0) {
                check2 = true;
            }
        }
        // 1. Check user input valid with else ifs
        if(check1 && check2){

            // 2. Check if user already exists with else ifs
            if(!userRepository.existsByUsername(user.getUsername())){

                // 3. Check if email already exists with else ifs
                if(!userRepository.existsByEmail(user.getEmail())){

                    // 4. Save data using Repository and BCrypt & Return 201 success message 
                    if(0==0){
                        
                        //BCrypt - with spring security
                        // https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html 
                        // Created encoder with strength 16 edited code from Spring security reference
                        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
                        String result = encoder.encode(user.getPassword());
                        // setPassword from User.java to update the password. Don't need to have a password saved already 
                        user.setPassword(result);
                        // save the password to the database
                        userRepository.save(user);
                        // Only for test classes 
                        //assertTrue(encoder.matches(user.getPassword(), result));

                        return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);
                    }
                    // Data couldn't save data using Repository and BCrypt or Couldn't return 201 success message  
                    else{
                        return new ResponseEntity<>("Please try again.", HttpStatus.BAD_REQUEST);
                    }
                }
                // Email already exists
                // Reset password?
                else{
                    return new ResponseEntity<>("Registration details given are not valid. Please try again.", HttpStatus.BAD_REQUEST);
                }
            }
            // User already exists
            // Reset password?
            else{
                return new ResponseEntity<>("Registration details given are not valid. Please try again.", HttpStatus.BAD_REQUEST);
            }
        }
        // User input invalid 
        else{
            //return new ResponseEntity<>("I'm a teapot", HttpStatus.I_AM_A_TEAPOT);
            //409 Conflict for user/email that already exists otherwise 400 Bad Request
            //return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
            return new ResponseEntity<>("Registration details given are not valid. Please try again.", HttpStatus.BAD_REQUEST);
        }
        // Change this
        //return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);
    }
/*
    // Added for @GetMaping needed for security to create XSRF-TOKEN cookie which is a bit ridiculous 
    // Not needed after all
    public ResponseEntity<?> securityToken(User user) {
        return new ResponseEntity<>(" ");
    }
/* 
    // Log In Process
    public ResponseEntity<?> loginUser(User user) {
        
        if(0==0){
            
        }
        else{

        }
    
    }

*/
}// Spring Initializr
