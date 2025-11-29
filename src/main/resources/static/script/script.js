document.getElementById("regform").addEventListener("submit", function(event){
    event.preventDefault();

    // Prevalidation checks
    // Vars for checking password has upper and lower case char in it  
    let hasUpperChar = false;
    let hasLowerChar = flase;

    // Vars for checking that password has a special char included in it 
    let hasSpecialChar = false;

    // Prevalidation - Does the password have upper and lower case char in it?
    for(let i = 0; i < password.length; i++){
        let char = password[i];
        // 
        if (char === char.toLowerCase() && char !== char.toUpperCase()) {
            hasLowerChar = true;
        }
        if (char === char.toUpperCase() && char !== char.toLowerCase()) {
            hasUpperChar = true;
        }
    }

    // Prevalidation - Does the password have a special char?
    for(let i = 0; i < password.length; i++){
        let specChar = password[i];
        if(specChar == "!" || specChar == "?" || specChar == "@" || specChar == "$"){
            hasSpecialChar = true;
        }
    }

    // Validation of registration input from user 
    if(email == confirmEmail){
        if(password == confirmPassword){
            if(password.length >= 16){
                if(hasSpecialChar == true){
                    if(hasUpperChar ==  true && hasLowerChar == true){
                        // If code gets this far - Password is vaild
                        const data = {
                            username: document.getElementById('username').value,
                            phone: document.getElementById('phone').value,
                            email: document.getElementById('email').value,
                            password: document.getElementById('password').value
                        };
                        fetch("/users",{
                            method: "POST",
                            headers: { "Content-Type": "application/json" },
                            body: JSON.stringify(data)
                        });
                    }
                    else{
                        // hasUpperChar !=  true || hasLowerChar != true
                        alert("Please try again \nThe password entered doesn't have upper and lower case characters");
                    }
                }
                else{
                    // hasSpecialChar == false
                    alert("Please try again \nThe password entered is missing a special character");
                }
            }
            else{
                // password.length < 16
                alert("Please try again \nThe password entered is not long enough");
            }
        }
        else{
            // password != confirmPassword
            alert("Please try again \nThe password entered did not match the confirm password entered");
        }
    }
    else{
        // email != confirmEmail
        alert("Please try again \nThe email entered did not match the confirm email entered");
    }

});