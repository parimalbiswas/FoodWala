package com.foodwala.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.LoginException;
import com.foodwala.model.CurrentUserSession;
import com.foodwala.model.Customer;
import com.foodwala.model.LoginDTO;
import com.foodwala.repository.CurrentUserSessionRepo;
import com.foodwala.repository.CustomerRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService
{

	@Autowired
	private CustomerRepo cRepo;

	@Autowired
	private CurrentUserSessionRepo cSessionRepo;

	@Override
	public String LogIntoAccount(LoginDTO dto) throws LoginException
	{

		Customer customers = (Customer) cRepo.findByMobileNumber(dto.getMobileNumber());

//		if (dto.getMobileNumber().equals("8981538252") && dto.getPassword().equals("8981538252"))
//		{
//			CurrentUserSession ExistcurrentUserSession = cSessionRepo.findByUseradminId(customers.getCustomer_id());
//
//			if (ExistcurrentUserSession == null)
//			{
//				CurrentUserSession currentUserSession = new CurrentUserSession();
//
//				currentUserSession.setUseradminId(customers.getCustomer_id());
//				currentUserSession.setUuid(RandomString.make(10));
//				currentUserSession.setLocalDateTime(LocalDateTime.now());
//				currentUserSession.setKonhai("ADMIN");
//				// currentUserSession.setCartId(customers.getCart().getCartId());
//				currentUserSession.setCartId(000000000000);
//				cSessionRepo.save(currentUserSession);
//				return currentUserSession.toString();
//			}
//			else
//			{
//				throw new LoginException("Session Already Exist== You aldeasy loged in");
//			}
//
//			
//		}

		if (customers.getPassword().equals(dto.getPassword()))
		{
			CurrentUserSession ExistcurrentUserSession = cSessionRepo.findByUseradminId(customers.getCustomer_id());

			if (ExistcurrentUserSession == null)
			{
				CurrentUserSession currentUserSession = new CurrentUserSession();

				currentUserSession.setUseradminId(customers.getCustomer_id());
				currentUserSession.setUuid(RandomString.make(10));
				currentUserSession.setLocalDateTime(LocalDateTime.now());
				currentUserSession.setKonhai("CUSTOMER");
				// currentUserSession.setCartId(customers.getCart().getCartId());
				currentUserSession.setCartId(000000000000);
				cSessionRepo.save(currentUserSession);
				return currentUserSession.toString();
			}
			else
			{
				throw new LoginException("Session Already Exist== You aldeasy loged in");
			}

		}
		else
		{
			throw new LoginException("Invalid Username or Password");
		}

	}

	@Override
	public String LogOutAccount(String key) throws LoginException
	{
		CurrentUserSession loggedInsession = cSessionRepo.findByUuid(key);
		if (loggedInsession == null)
		{
			throw new LoginException("user is not logged in");
		}
		else
		{
			cSessionRepo.delete(loggedInsession);
			return "Logged Out successfully";
		}
	}

}
