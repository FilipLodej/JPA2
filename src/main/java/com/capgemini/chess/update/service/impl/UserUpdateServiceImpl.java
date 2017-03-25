package com.capgemini.chess.update.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.exception.UserValidationException;
import com.capgemini.chess.update.service.UserUpdateService;
import com.capgemini.chess.update.service.UserValidationService;
import com.capgemini.chess.update.to.UserTo;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

	@Autowired
	private UserValidationService userValidationService;
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserTo updateUser(UserTo userTo) throws UserValidationException {
		userValidationService.validate(userTo);
		return userDao.update(userTo);
	}
}
