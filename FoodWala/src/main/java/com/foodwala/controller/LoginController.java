package com.foodwala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.LoginException;
import com.foodwala.model.LoginDTO;
import com.foodwala.service.LoginService;

@RestController
public class LoginController
{
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<String> LogIntoAccountHandler(@RequestBody LoginDTO loginDTO) throws LoginException
	{
		String session = loginService.LogIntoAccount(loginDTO);

		return new ResponseEntity<>(session, HttpStatus.CREATED);
	}

	@PostMapping("/logout/{key}")
	public ResponseEntity<String> LogIntoAccountHandler(@PathVariable("key") String key) throws LoginException
	{
		String session = loginService.LogOutAccount(key);

		return new ResponseEntity<>(session, HttpStatus.CREATED);
	}

}
