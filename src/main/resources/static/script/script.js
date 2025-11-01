//function form(){
    //const username = document.getElementById("username");
    //const phone = document.getElementById("phone");
    //const email = document.getElementById("email");
    //const password = document.getElementById("password");

    // validate data  
//}

    // Test                                              
    console.log("............Inside JavaSript Class............");

    // id="regButton" from html
    //var reg = document.getElementById("regButton");
    //reg.addEventListener("click", regFunction);
    //reg.addEventListener(onclick, regFunction);

    //document.getElementById('myform').onsubmit = function(event){
    // apparently addEventListener is more modern and preferred and "best practice" as it lets me add multiple listeners to the same event, and is more flexible. according to Codecademy AI.
    // .addEventListener is a flexible approach and allows you to add multiple event listeners to the same element and does not overwrite any existing handlers.
    document.getElementById('myform').addEventListener("submit"), function(event){
        event.preventDefault();
         
        // Test                                              
        console.log("............Inside document.getElementById in JavaScript............");
/*
        // Trying to get the data entered into the form into JavaScript class
        const username = document.getElementById('username').value;
        //const phone = document.getElementById('phone').ariaValueMax;//.value auto changed
        const phone = document.getElementById('phone').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
*/
        //01.11.2025
        

        // Aprox 29.10.2025 - Validate data in client side 

        // Aprox 29.10.2025 -  Export data as JSON to UserService class for server side 
        // Aprox 29.10.2025 -  Send via fetch() or XMLHttpRequest
        // Aprox 29.10.2025 -  Convert data to JSON with JSON.stringify()

        // Aprox 29.10.2025 -  ServiceUser needs to collect/be sent the data
        // Aprox 29.10.2025 -  UserController needs to then get the data and save reg data to database
        


    };


    function regFunction(){
       
        // W3 Schools
        // const myObj = Object.fromEntries(fruits);
        
        // Test                                              
        console.log("Inside the regFunction of JavaScript");





    }


