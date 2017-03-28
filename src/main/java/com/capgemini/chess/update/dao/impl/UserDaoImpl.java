package com.capgemini.chess.update.dao.impl;

import org.springframework.stereotype.Service;
import com.capgemini.chess.statistics.dao.impl.AbstractDao;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.dataaccess.entities.UserEntity;
import com.capgemini.chess.update.service.mapper.UserMapper;
import com.capgemini.chess.update.to.UserTo;

@Service
public class UserDaoImpl extends AbstractDao<UserEntity, Long> implements UserDao {

	@Override
	public UserTo update(UserTo userTo) {
		return UserMapper.map(update(UserMapper.map(userTo)));
	}

	@Override
	public UserTo findByID(Long id) {
		return UserMapper.map(findOne(id));
	}

	@Override
	public UserTo updateRanking(UserEntity user) {
		//TODO 
		return null;
	}

	@Override
	public UserTo updatePoints(UserTo userTo, int points) {
		//TODO
		return null;
	}
}
