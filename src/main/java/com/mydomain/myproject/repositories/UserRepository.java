// Helper to fetch and save data - It acts like a bridge between app and database
// Output is only available on the server side unless controller gives access 
package com.mydomain.myproject.repositories;// Spring Initializr

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.mydomain.myproject.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
    /*
    Here we are searching to see if the username or email exists within the database
    Then will return the row of the database to the controller class if it finds it  
    JPA automatically implements the below method for log in
    */
    Boolean existsByUsername(String username);
    User findByUsername(String username);
    
    Boolean existsByEmail(String email);
    User findByEmail(String email);

}// Spring Initializr
