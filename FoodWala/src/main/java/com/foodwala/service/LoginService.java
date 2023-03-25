package com.foodwala.service;

import org.springframework.stereotype.Service;

import com.foodwala.exception.LoginException;
import com.foodwala.model.LoginDTO;

@Service
public interface LoginService
{
	public String LogIntoAccount(LoginDTO dto) throws LoginException;

	public String LogOutAccount(String key) throws LoginException;

}
