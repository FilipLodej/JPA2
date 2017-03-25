package com.capgemini.chess.update.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.dataaccess.entities.UserEntity;
import com.capgemini.chess.update.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.update.service.mapper.UserMapper;
import com.capgemini.chess.update.to.UserTo;
@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private MapDataSource dataSource;

	@Override
	public UserTo update(UserTo user) {
		UserEntity userEntity = UserMapper.map(user);
		long userId = userEntity.getId();
		dataSource.getUsers().put(userId, userEntity);
		return UserMapper.map(userEntity);
	}

	@Override
	public UserTo findByID(Long id) {
		UserEntity userFoundById = dataSource.getUsers().values().stream().filter(u -> u.getId().equals(id)).findFirst()
				.orElse(null);
		return UserMapper.map(userFoundById);
	}

	@Override
	public UserTo updateRanking(UserEntity user) {
		UserEntity userEntity = user;
		long userId = userEntity.getId();
		dataSource.getUsers().put(userId, userEntity);
		return UserMapper.map(userEntity);
	}

	@Override
	public UserTo updatePoints(UserTo userTo, int points) {
		UserEntity userEntity = UserMapper.map(userTo);
		long userId = userEntity.getId();
		int sumPoints = userEntity.getStatistic().getPoints();
		int numberOfPlayedGames=userEntity.getStatistic().getPlayed();
		sumPoints += points;
		numberOfPlayedGames++;
		userEntity.getStatistic().setPoints(sumPoints);
		userEntity.getStatistic().setPlayed(numberOfPlayedGames);
		dataSource.getUsers().put(userId, userEntity);
		return UserMapper.map(userEntity);
	}

}
