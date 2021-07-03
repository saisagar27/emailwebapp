package com.te.mailapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mailapp.beans.User;
import com.te.mailapp.dao.MailAppDAO;

@Service
public class MailAppServiceImpl implements MailAppService{

@Autowired
private MailAppDAO dao;
	@Override
	public User getLogin(String username,String password) {
		if(username!=null && password!=null && password!="" && username!="") 
			return dao.getLogin(username,password);
	
		else
		return null;
	}
	@Override
	public User register(User user) {
		
		
			return dao.register(user);
		
	}
	@Override
	public User fetchEmail(String email) {
		// TODO Auto-generated method stub
		return dao.fetchEmail(email);
	}
	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		return dao.loginUser(user);
	}

}
