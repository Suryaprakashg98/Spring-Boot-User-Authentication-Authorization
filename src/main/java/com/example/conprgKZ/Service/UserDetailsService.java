 package com.example.conprgKZ.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.conprgKZ.Entity.UserDetails;
import com.example.conprgKZ.Repository.UserDetailsRepository;
import com.example.conprgKZ.Request.LoginRequest;
import com.example.conprgKZ.Request.UserDetailsRequest;

@Service
public class UserDetailsService {
	@Autowired
	UserDetailsRepository userRepository;
	
	 public String Register(UserDetailsRequest userDetailssRequest) {
	        String mailId = userDetailssRequest.getEmail();
	        
	        
	        Optional<UserDetails> userDetailsOptional = userRepository.findByEmail(mailId);

	        if (!userDetailsOptional.isPresent()) {
	        	
	        	UserDetails cd = new UserDetails();
                            
           
	            if (userDetailssRequest.getUsername() != null && userDetailssRequest.getUsername().length() <= 30 &&
	            		userDetailssRequest.getUsername().trim().length() > 0) {
	                cd.setUsername(userDetailssRequest.getUsername());
	            } else {
	                return "Invalid Username";
	            }
	            if (userDetailssRequest.getPassword() != null && userDetailssRequest.getPassword().length() <= 30
	                    && userDetailssRequest.getPassword().trim().length() > 0) {
	                cd.setPassword(userDetailssRequest.getPassword());
	            } 
	            else {
	                return "Invalid password";
	            }

	            
	           
	            if (userDetailssRequest.getMobileNo() != null && userDetailssRequest.getMobileNo().length() <= 10 &&
	            		userDetailssRequest.getMobileNo().length() >= 10) {
	                cd.setMobileNo(userDetailssRequest.getMobileNo());
	            } 
	            else {
	                return "invalid Mobile Number";
	            }                      
	            //Regular Expression
	            Pattern p = Pattern.compile("^(?!.{101})[\\w]{5,}@([\\w]+\\.)+[\\w]+$", Pattern.CASE_INSENSITIVE);

	            Matcher m = p.matcher(userDetailssRequest.getEmail());
	            boolean b = m.matches();
	            if ((userDetailssRequest.getEmail() != null && userDetailssRequest.getEmail().length() <= 100
	                    && userDetailssRequest.getEmail().trim().length() > 0 && b)) {
	                cd.setEmail(userDetailssRequest.getEmail());
	            } else {
	                return "invalid email";
	            }
	             
	            userRepository.save(cd);
	            
	            return "User Details Added Successfully";
	        } 
	        else {
	            return "This email id is already registered";
	        }
	    }
	        public String Login(LoginRequest loginRequest) {
	        String email = loginRequest.getEmail();
	        String password = loginRequest.getPassword();
	        Optional<UserDetails> userDetailsOptional = userRepository.findByEmailAndPassword(email, password);
	        
	        if (userDetailsOptional.isPresent()) {
	        	
	            return "Login Success";
	        } 
	        else {
	            return "Login Failed";
	        }
	    }
	 
/*	 //localhost forgot password
	 public Optional<UserDetails> getUserDetails(String email) {
			
		 return userRepository.findByEmail(email);
		
	}
	 
	 public void updatePssword(UserDetails userDetails ,String email) {
			
		 userRepository.save(userDetails);
		}*/
	
	 }
