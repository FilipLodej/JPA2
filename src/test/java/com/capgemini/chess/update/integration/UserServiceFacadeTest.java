package com.capgemini.chess.update.integration;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.exception.UserValidationException;
import com.capgemini.chess.update.service.UserServiceFacade;
import com.capgemini.chess.update.to.UserTo;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceFacadeTest {

	@Autowired
	UserServiceFacade userServiceFacade;
	@Autowired
	UserDao userDao;
	
	@Test
	public void shouldUpdateUser() throws UserValidationException{
		//given
		UserTo userToUpdate=userDao.findByID(1l);
		String newLogin="NowyLogin";
		String newPassword="123456789";
		//when
		userToUpdate.setLogin(newLogin);
		userToUpdate.setPassword(newPassword);
		UserTo userAfterUpdate=userServiceFacade.updateUser(userToUpdate);
		//then
		assertEquals("NowyLogin",userAfterUpdate.getLogin());
	}
	
	@Test(expected = UserValidationException.class)
	public void shouldThrowPasswordValidationException() throws UserValidationException{
		//given
		UserTo userToUpdate=userDao.findByID(1l);
		String newLogin="NowyLogin";
		String newPassword="123";
		//when
		userToUpdate.setLogin(newLogin);
		userToUpdate.setPassword(newPassword);
		userServiceFacade.updateUser(userToUpdate);
		//then
		
	}
	
	@Test(expected = UserValidationException.class)
	public void shouldThrowValidationExceptionIdDoesntExists() throws Exception{
		//given
		UserTo userToUpdate=userDao.findByID(1l);
		//when
		userToUpdate.setId(10L);
		userServiceFacade.updateUser(userToUpdate);
		//then
		
	}
	
	
	
}
