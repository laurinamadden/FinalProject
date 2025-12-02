package com.mydomain.myproject.controllers;// Spring Initializr

//Imports other classes in this project
import com.mydomain.myproject.entities.User;
// repository should not have direct access to controller or 
//import com.mydomain.myproject.repositories.UserRepository;
import com.mydomain.myproject.services.UserService;

//Imports - Annotations
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import java.security.NoSuchAlgorithmException;
//import java.util.Map;

//27.11.2025 - Codecademy AI - Can I have else ifs within the controller class? Yes

@RestController
@RequestMapping("/users")
public class UserController {// Spring Initializr
    /*
    //Instantiate an object: UserRespository 
    private final UserRepository userRepository;

    public UserController (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    //Instantiate an object: UserService added due to VS errors when server was run
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
        Causing an issue having both of these so tried to combine them as I need them both
    */
    //Instantiate an object: UserRespository and UserService 
    /*26.11.2025 - The controller should not have direct acess to the repository class so commented this out  
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController (UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
    }
    Controller should only have access to the service class who then talks to the repository class 
    */
    // Instantiate an object: UserService added back this time due to logic client->Controller->Service->Repository->service->controller->client. Codecademy AI says it should follow "the separation of concerns principle"
    private final UserService userService;
    // Constructor 
    public UserController(UserService userService) {
        this.userService = userService;
    }

/*
    // endpoint should still be /users
    //@PostMapping("/users") // commented out on 02.11.2025 due to POST not supported and status 405 errors
    @PostMapping // 02.11.2025 - now getting errors T"Content-Type 'application/x-www-form-urlencoded;charset=UTF-8' is not supported]" & Browser"Whitelabel Error Page This application has no explicit mapping for /error, so you are seeing this as a fallback. Sun Nov 02 16:49:21 GMT 2025 There was an unexpected error (type=Unsupported Media Type, status=415)."
    //01.11.2025 - codecademy ai 
    //If you want to use @RequestBody, you must send JSON from the client. This means you need to use JavaScript and JSON.stringify() to send the data as JSON, not as regular form data.
    // JSON comes from client side with @RequestBody User user
   
    public String createUser(@RequestBody User user){
/*
    //public String createUser(@ModelAttribute User user){ //- codecademy advised but it doesnt work
    //public String createUser(User user){ - codecademy advised to use this instead but it doesnt work
        //System.out.println("Inside UserController PostMapping createUSer. Print to terminal.");
        // 27.11.2025 - this should be in the service class not the controller class 
        //this.userRepository.save(user);
        // 22.11.2025 - This doesnt look like it would be right 
        return "Message";
    }
*/
    // Replacement code?
    //Handles HTTP POST method sent to the end point /users
    @PostMapping("/users")
    // When Post method for endpoint /users is triggered the first function below will run  
    // <?> responce can be any type. It returns ResponseEntity
    // ResponseEntity is from the spring library 
    public ResponseEntity<?> reg(@RequestBody User user) {
        return userService.regUser(user);
    }
    
    @PostMapping("/users")
    public ResponseEntity<?> logIn(@RequestBody User user) {
        return userService.loginUser(user);
    }

    /*
    Failed
    @PostMapping(path="/register")
    public String createUser(@RequestBody User user){
    //public String createUser(@RequestParam String username, @RequestParam Integer phone, @RequestParam String email, @RequestParam String password){
        //User createUser = new User(username, phone, email, password);
        //new User(username, phone, email, password);
        //userRepository.save(user);
        return "Message";
    }
    */
/*
    // endpoint is still /users
    @GetMapping
    //UserRepository initialized within this method 
    //27.11.2025 repository shouldmt be accessed through controller
    public Iterable<User> getAllUsers(){
        // 27.11.2025 - this should be in the service class not the controller class  
        //return this.userRepository.findAll();
    }

    @GetMapping(path="/byusername/{username}")
    //public Iterable<User> getUserByUsername(@PathVariable String username){ - VS didnt like this
    public User getUserByUsername(@PathVariable String username){    
        //return userRepository.findByUsername(username);
        // 23.11.2025 - Changed to userService to use the service class instead of repository class
        //return userService.findByUsername(username);
        // 23.11.2025 - Changed .findByUsername to .findUser to match UserService class
        return userService.findUser(username);
    }


    @GetMapping(path="/byemail/{email}")
    //public Iterable<User> getUserByEmail(@PathVariable String email){ - VS didnt like this
    public User getUserByEmail(@PathVariable String email){
        // 27.11.2025 - this should be in the service class not the controller class 
        //return userRepository.findByEmail(email);
    }
*/
    //@PutMapping
    

    //@DeleteMapping
    /* 
    @PostMapping("/login") 
    //@RequestMapping("/login")
    @PostMapping("/login")
    // Loginrequest 
    public Boolean controllerLogin(@RequestBody LoginStorage loginStorage) {
        return userService.loginH(loginStorage.getUsername(), loginStorage.getPassword());
    }
    commented code out because it causes an error when building the server need to find another way to do this
    @PostMapping("/login")
    public Boolean logIn(@RequestBody Map<String, String> data) throws NoSuchAlgorithmException {
        String username = data.get("loginUsername");
        String password = data.get("loginPassword");
        return userService.loginH(username, password);
    }
    was still getting error with this code till the import was manually entered
    
    @PostMapping("/login")
    public Boolean logIn(@RequestBody Map<String, String> data) {
        try {
            return userService.loginH(data.get("loginUsername"), data.get("loginPassword"));
        } 
        catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
    */
}// Spring Initializr
