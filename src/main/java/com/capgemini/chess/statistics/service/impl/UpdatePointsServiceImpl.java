package com.capgemini.chess.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.service.UpdatePointsService;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.to.UserTo;
@Service
public class UpdatePointsServiceImpl implements UpdatePointsService {

	@Autowired
	UserDao userDao;

	@Override
	public UserTo addPointsToUser(UserTo userTo, int points) {
		return userDao.updatePoints(userTo, points);
	}
}
