//function form(){
    //const username = document.getElementById("username");
    //const phone = document.getElementById("phone");
    //const email = document.getElementById("email");
    //const password = document.getElementById("password");

    // validate data  
//}

    // Test output to Console on webpage
    console.log("............Inside JavaSript Class............");
    // Test output to Terminal 
    // System.out.println("............Inside JavaSript Class............");

    // id="regButton" from html
    //var reg = document.getElementById("regButton");
    //reg.addEventListener("click", regFunction);
    //reg.addEventListener(onclick, regFunction);

    // document.getElementById('myform').onsubmit = function(event){
    // apparently addEventListener is more modern and preferred and "best practice" as it lets me add multiple listeners to the same event, and is more flexible. according to Codecademy AI.
    // .addEventListener is a flexible approach and allows you to add multiple event listeners to the same element and does not overwrite any existing handlers.
    // 01.11.2025 - I had an extra bracket ("submit") - removed it today as advised by Codecademy AI
    
    document.getElementById("regform").addEventListener("submit", function(event){
        event.preventDefault();
         
        // Test                                              
        console.log("............Inside document.getElementById in JavaScript............");
        // console.log("...Test output...");
/*
        // 29.10.2025 - Trying to get the data entered into the form into JavaScript class
        const username = document.getElementById('username').value;
        //const phone = document.getElementById('phone').ariaValueMax;//.value auto changed
        const phone = document.getElementById('phone').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
*/
        //01.11.2025
        // console.log("Above const data");
        const data = {
            username: document.getElementById("username").value,
            phone: document.getElementById("phone").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        };

        // Aprox 29.10.2025 - Validate data in client side

        // Aprox 29.10.2025 -  Export data as JSON to UserService class for server side 

        // Aprox 29.10.2025 -  Send via fetch() or XMLHttpRequest
        // 01.11.2025 - fetch() will send POST request with header Content-Type: application/json
        // console.log("Above fetch in script.js");
        fetch("/users",{
            method: "POST",
            headers: { "Content-Type": "application/json" },
            // Aprox 29.10.2025 -  Convert data to JSON with JSON.stringify()
            // 01.11.2025 - JSON.stringify() converts the data to JSON for server side
            body: JSON.stringify(data)
        });

        /*
        window.location.href = "../login/index.html";
        window.location.replace("index.html");
        Go to log in page
        */
        // console.log("Move to logIn page. Test relative path");
        // 15.11.2025 - This has worked so the relative path must work and the code in this fuction must get down to 
        window.location.href = "../login/index.html";



        // Aprox 29.10.2025 -  ServiceUser needs to collect/be sent the data
        // Aprox 29.10.2025 -  UserController needs to then get the data and save reg data to database
        


    });


    //function regFunction(){
       
        // W3 Schools
        // const myObj = Object.fromEntries(fruits);
        
        // Test                                              
       // console.log("Inside the regFunction of JavaScript");





    //}


