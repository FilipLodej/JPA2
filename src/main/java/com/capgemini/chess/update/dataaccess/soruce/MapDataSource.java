package com.capgemini.chess.update.dataaccess.soruce;

import java.util.List;
import java.util.Map;

import com.capgemini.chess.update.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.update.dataaccess.entities.UserEntity;

public interface MapDataSource {

	Map<Long, UserEntity> getUsers();
	Map<Long, ProfileEntity> getProfile();
	List<UserEntity> getAllUsers();
}
