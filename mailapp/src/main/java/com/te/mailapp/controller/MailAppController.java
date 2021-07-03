package com.te.mailapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.mailapp.beans.User;
import com.te.mailapp.service.MailAppService;

@RestController
public class MailAppController {
	
	@Autowired
	private MailAppService service;
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getuser/{username}/{password}")
	public User validate(@PathVariable String username,@PathVariable String password) {
		User user=service.getLogin(username, password);
		if(user!=null) {
			user.getUser_name();
			user.getPassword();
		}
		return user;
		
		
	}
	@PostMapping("/registeruser")
	public User register(@RequestBody User user) throws Exception {
//		String tempEmail=user.getEmail();
//		if(tempEmail!=null && !"".equals(tempEmail)) {
//			
//			User u1=service.fetchEmail(tempEmail);
//			if(u1!=null) {
//				throw new Exception("Email "+tempEmail+" already present");
//			}
//			
//		}
//
//		
			User uu=service.register(user);
				return uu;
	
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public User validate(@RequestBody User u) throws Exception {
		
		String username=u.getUser_name();
		String password=u.getPassword();
		
		
		User user = null;
		if(username!=null && password!=null) {
			 user=service.loginUser(u);
			
		}
		if(user == null) {
			throw new Exception("BAD Credentials");
		}
		
		return user;
		
		
}
}
	

	
	
