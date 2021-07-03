package com.te.mailapp.dao;

import com.te.mailapp.beans.User;

public interface MailAppDAO {
	public User getLogin(String username,String Password);
	
	public User register(User u) ;
	public User loginUser(User u) ;
	
	public User fetchEmail(String email);

}
