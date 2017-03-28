package com.capgemini.chess.update.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.service.UserValidationService;
import com.capgemini.chess.update.service.impl.UserUpdateServiceImpl;
import com.capgemini.chess.update.to.UserTo;

@RunWith(MockitoJUnitRunner.class)
public class UserUpdateServiceImplTest {

	@Mock
	UserDao userDao;
	@Mock
	UserValidationService userValidService;
	@InjectMocks
	UserUpdateServiceImpl userUpdateService;

	@Test
	public void shouldValidateAndThenUpdateProfileAndUser() throws Exception {
		// given
		UserTo userToUpdate = new UserTo();
		// when
		userUpdateService.updateUser(userToUpdate);
		// then
		InOrder inOrder = Mockito.inOrder(userValidService, userDao);
		inOrder.verify(userValidService).validate(userToUpdate);
		inOrder.verify(userDao).update(userToUpdate);
	}

}
