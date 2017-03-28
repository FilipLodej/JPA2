package com.capgemini.chess.update.dao;

import com.capgemini.chess.update.to.UserTo;

public interface UserDao {
	
	 UserTo update(UserTo userTo);
	 UserTo findByID(Long id);
}
