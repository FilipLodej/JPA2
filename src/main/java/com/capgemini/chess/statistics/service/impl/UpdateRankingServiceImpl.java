package com.capgemini.chess.statistics.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.service.UpdateRankingService;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.dataaccess.entities.UserEntity;
import com.capgemini.chess.update.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.update.to.UserTo;

@Service
public class UpdateRankingServiceImpl implements UpdateRankingService {

	@Autowired
	MapDataSource mapDataService;

	@Autowired
	UserDao userDao;

	@Override
	public UserTo updateRanking(UserTo userTo) {
		List<UserEntity> users = mapDataService.getAllUsers();
		UserComparator comparator = new UserComparator();
		Collections.sort(users, comparator);
		UserEntity user = getUser(users, userTo);
//		int position = users.indexOf(user);
//		user.getStatistic().setPosition(position);
		return userDao.updateRanking(user);
	}

	private UserEntity getUser(List<UserEntity> users, UserTo userTo) {
		long userId = userTo.getId();
		UserEntity foundUser = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
		return foundUser;
	}
}
