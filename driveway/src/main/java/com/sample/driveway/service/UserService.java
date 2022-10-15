package com.sample.driveway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.driveway.model.User;
import com.sample.driveway.repository.UserRepository;

@Service
public class UserService 
{
    @Autowired
    UserRepository userRepository;
	
	public String storeUserDetails(User user) 
    {
		if(!userRepository.existsById(user.getEmail())) 
        {
			userRepository.save(user);
			return "User Added Successfully!";
		}
        else 
        {
			return "User Already Exists!!!";
		}
	}
	
	public String checkUserDetails(User user) 
    {
		   if(userRepository.existsById(user.getEmail())) 
           {
			   User u = userRepository.getReferenceById(user.getEmail());
			   if(u.getPassword().equals(user.getPassword())) 
               {
				   return "You Logged In Successfully!";
			   }
               else 
               {
				   return "Please Enter Correct Details";
			   }				   
		   }
           else 
           {
			   return "Your Details Are Not Exists!!";
		   }   
	   }
	
    public String userLogout(String email) 
    {
        if(userRepository.existsById(email)) 
        {
            return "Logout Successful!";
        }
        else 
        {
            return "Please Enter Correct Details";
        }				   	   
    }
	
	public String updateUserDetails(User user) 
    {
		if(userRepository.existsById(user.getEmail())) 
        {
			User u=userRepository.getReferenceById(user.getEmail());
			if(u.getPassword().equals(user.getPassword())) 
            {
				return "You are entering already existing details";
			}
            else 
            {
				u.setPassword(user.getPassword());
				userRepository.saveAndFlush(u);
				return "User Updated Successfully!";
			}
		}
        else 
        {
			return "User not Exists!!";			
		}						
	}
	
	public List<User> getAllUsersDetails() 
    {
		return userRepository.findAll();
	}

	public String deleteUserDetails(String email) 
    {
		if(!userRepository.existsById(email)) 
        {
			return "User not Exists!!";
		}
        else 
        {
			userRepository.deleteById(email);
			return "User Deleted Successfully!";
		}
	}
}
