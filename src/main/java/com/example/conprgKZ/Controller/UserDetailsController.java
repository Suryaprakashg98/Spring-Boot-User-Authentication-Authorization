package com.example.conprgKZ.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.conprgKZ.Request.LoginRequest;
import com.example.conprgKZ.Request.UserDetailsRequest;
import com.example.conprgKZ.Service.UserDetailsService;

@RestController
public class UserDetailsController {

	    @Autowired
	    private UserDetailsService userService;

	    @PostMapping("/register")
	    public String Registration(@RequestBody UserDetailsRequest userDetailsRequest) {
	        return userService.Register(userDetailsRequest);
	    }
	
	    @PostMapping("/login")
	    public String Login(@RequestBody LoginRequest loginRequest) {
	        return userService.Login(loginRequest);
	    }
	    
	 /*   @GetMapping("/forgotpassword/{email}")
		public  Optional<UserDetails> getUserDetails(@PathVariable("email") String email) {
			
			return userService.getUserDetails(email);
			
		}
	    
	    @PutMapping("/forgotpassword/{email}")
		public String   ForgotPassword(@RequestBody UserDetails userdetails,String email  ) {
			
	    	userService.updatePssword(userdetails,email);
			return "UserPassword Updated Successfully";
			
		}*/

}
