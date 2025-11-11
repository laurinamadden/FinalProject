/* 
Notes written by Laurina Madden  - Student Number x20200765
Purpose of this class is to hold data and can have logic in it too 
This is the Entity Class for our users 
*/
package com.mydomain.myproject.entities;// Spring Initializr

// Imports - 
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// When I looked up what jakarta.persistence was it seems that it is a newer version of javax.persistence so I edited the lines already created to match as VScode is unhappy with javax.persistence
import jakarta.persistence.Id;// Auto created by VS code. 

@Entity
@Table(name = "Users")
public class User {// Spring Initializr
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PHONE")
    private Integer phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    public User() {
        // required by JPA and Spring
        // for frameworks
    }
    
    // is for your own use when you want to create a user in your code
    public User(String username, Integer phone, String email, String password) { //TODO Auto-generated constructor stub but I removed the 2s it had username2 etc
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    /*
    Codecademy AI
    "If you only have the second one, Spring/JPA will not work properly.
    If you have both, everything will work!"
    */

    public String getUsername() {
        return username;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Can set up setters in time so that the data can be updated 

}// Spring Initializr
