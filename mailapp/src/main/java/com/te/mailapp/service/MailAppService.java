package com.te.mailapp.service;

import com.te.mailapp.beans.User;

public interface MailAppService {

	
	public User getLogin(String username,String password);
	
	public User register(User user);
	
	public User loginUser(User user);
	
	public User fetchEmail(String email);
}
