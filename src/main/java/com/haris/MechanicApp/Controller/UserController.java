package com.haris.MechanicApp.Controller;

import com.haris.MechanicApp.Model.Verification.ForgotEmail;
import com.haris.MechanicApp.Model.Verification.Token;
import com.haris.MechanicApp.Model.Verification.User;
import com.haris.MechanicApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
  AuthenticationManager authenticationManager;


    @Autowired
    UserService userService;



    @GetMapping ("/")
    public String home (){

        return "hello world";
    }


    @PostMapping ("api/user/register")

    public ResponseEntity <?> registration (@RequestBody User user){

        return userService.register(user);
}

@PostMapping ("api/verify/user/token")
    public ResponseEntity<?> verifyRegistration (@RequestBody Token token
                                               ){
return userService.verifyRegistration(token.getToken() ,token.getEmail() );
}
    @PostMapping("api/user/login")
    public ResponseEntity<?> loginUser (@RequestBody User user  ){
        return userService.login(user ,authenticationManager);
    }

    @PostMapping("api/user/forgot")
    public ResponseEntity<?> forgotPasswords (@RequestBody ForgotEmail email){

            return userService.forgotpasswords(email.getEmail());

    }

    @PostMapping ("api/user/forget/verify")
    public ResponseEntity<?> verifynewPasswordToken (@RequestBody Token token){

            return userService.verifynewPasswordToken (token);

    }

    @PostMapping ("api/user/newPassword")
    public ResponseEntity<?> updatepassword (@RequestBody User user){

        return userService. updatePassword (user);

    }

}

