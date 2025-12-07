// Written by Laurina Madden 
// Student Number x20200765
// 30.11.2025 - Celebration :) Registration is working :)
// Registration script.js Process
document.getElementById("regform").addEventListener("submit", function(event){
    event.preventDefault();

    const data = {
        username: document.getElementById('username').value,
        phone: document.getElementById('phone').value,
        email: document.getElementById('email').value,
        //confirmEmail: document.getElementById('confirmEmail').value,
        password: document.getElementById('password').value
        //confirmPassword: document.getElementById('confirmPassword').value
    };    

    const confirm = {
        confirmEmail: document.getElementById('confirmEmail').value,
        confirmPassword: document.getElementById('confirmPassword').value
    };

    // Prevalidation checks
    // Vars for checking password has upper and lower case char in it  
    let hasUpperChar = false;
    let hasLowerChar = false;

    // Vars for checking that password has a special char included in it 
    let hasSpecialChar = false;


    // Prevalidation - Does the password have upper and lower case char in it?
    for(let i = 0; i < data.password.length; i++){
        let char = data.password[i];
        // 
        if (char === char.toLowerCase() && char !== char.toUpperCase()) {
            hasLowerChar = true;
        }
        if (char === char.toUpperCase() && char !== char.toLowerCase()) {
            hasUpperChar = true;
        }
    }

    // Prevalidation - Does the password have a special char?
    for(let i = 0; i < data.password.length; i++){
        let specChar = data.password[i];
         if(specChar == "!" || specChar == "?" || specChar == "@" || specChar == "$"){
            hasSpecialChar = true;
        }
    }

    // Validation of registration input from user 
    if(data.email == confirm.confirmEmail){
        if(data.password == confirm.confirmPassword){
            // For best practice
            //if(password.length >= 16){
            // For testing 
            if(data.password.length > 4){
                //if(hasSpecialChar == true){
                if(hasSpecialChar){
                    //if(hasUpperChar ==  true && hasLowerChar == true){
                    if(hasUpperChar && hasLowerChar){
                        // If code gets this far - Password is vaild
                        /*
                        const data = {
                            username: document.getElementById('username').value,
                            phone: document.getElementById('phone').value,
                            email: document.getElementById('email').value,
                            password: document.getElementById('password').value
                        };
                        */
                        const token = document.cookie
                            .split('; ')
                            .find(row => row.startsWith('XSRF/CSRF-TOKEN='))
                            ?.split('=')[1];

                        fetch("/users",{
                            method: "POST",
                            headers: { 
                                "Content-Type": "application/json",
                                "X-XSRF-TOKEN" : token 
                            },
                            body: JSON.stringify(data)
                        });
                        //window.location.href = "../login/index.html";
                        
                    }
                    else{
                        // hasUpperChar !=  true || hasLowerChar != true
                        alert("JavaScript.Please try again \nThe password entered doesn't have upper and lower case characters");
                    }
                }
                else{
                    // hasSpecialChar == false
                    alert("JavaScript.Please try again \nThe password entered is missing a special character");
                }
            }
            else{
                // password.length < 16
                alert("JavaScript.Please try again \nThe password entered is not long enough");
            }
        }
        else{
            // password != confirmPassword
            alert("PJavaScript.lease try again \nThe password entered did not match the confirm password entered");
        }
    }
    else{
        // email != confirmEmail
        alert("JavaScript.Please try again \nThe email entered did not match the confirm email entered");
    }

});

// Log in script.js Process
document.getElementById("loginform").addEventListener("submit", function(event){
    event.preventDefault();
    
    // Is best practice 
    const data = {
        username: document.getElementById("loginUsername").value,
        password: document.getElementById("loginPassword").value
    };
    
    // Vars for checking that password has a special char included in it 
    let hasSpecialChar = false;

    for(let i = 0; i < data.loginPassword.length; i++){
        let specChar = data.loginPassword[i];
         if(specChar == "!" || specChar == "?" || specChar == "@" || specChar == "$"){
            hasSpecialChar = true;
        }
    }

    // Validate log in details
    if(hasSpecialChar){
        if(0==0){    
            // entities/Login.java has been created and can be used    
            const token = document.cookie
                .split('; ')
                .find(row => row.startsWith('XSRF/CSRF-TOKEN='))
                ?.split('=')[1];

            fetch("/login",{
            // entities/User.java could be used but dont think it is set up to take this data 
            //fetch("/users",{
                method: "POST",
                headers: { 
                    "Content-Type": "application/json",
                    "X-XSRF-TOKEN" : token 
                },
                body: JSON.stringify(data)
            });
        }
        else{
            window.location.href = "../index.html";
        }
    // Logged in. Need to allow access to groupOptions/index.html once logged in
    window.location.href = "../groupOptions/index.html";
    }
    else{
        alert("JavaScript.Please try again \nThe password entered is missing a special character");
    }

});