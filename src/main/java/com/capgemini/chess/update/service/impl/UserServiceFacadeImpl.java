package com.capgemini.chess.update.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.chess.update.exception.UserValidationException;
import com.capgemini.chess.update.service.UserServiceFacade;
import com.capgemini.chess.update.service.UserUpdateService;
import com.capgemini.chess.update.to.UserTo;

@Service
@Transactional
public class UserServiceFacadeImpl implements UserServiceFacade {

	@Autowired
	private UserUpdateService userUpdateService;

	@Override
	public UserTo updateUser(UserTo UserTo) throws UserValidationException {
		return userUpdateService.updateUser(UserTo);
	}

}
