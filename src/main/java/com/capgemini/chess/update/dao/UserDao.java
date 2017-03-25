package com.capgemini.chess.update.dao;

import com.capgemini.chess.update.dataaccess.entities.UserEntity;
import com.capgemini.chess.update.to.UserTo;

public interface UserDao {
	
	 UserTo update(UserTo userTo);
	 UserTo findByID(Long id);
	 UserTo updateRanking(UserEntity user);
	 UserTo updatePoints(UserTo userTo, int points);
}
