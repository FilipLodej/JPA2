package com.capgemini.chess.update.service;


import com.capgemini.chess.update.exception.UserValidationException;

import com.capgemini.chess.update.to.UserTo;

public interface UserServiceFacade {
	UserTo updateUser(UserTo userTo) throws UserValidationException;

}
