package com.capgemini.chess.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.StatisticDao;
import com.capgemini.chess.statistics.service.UpdatePointsService;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.to.UserTo;

@Service
public class UpdatePointsServiceImpl implements UpdatePointsService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	StatisticDao statisticDao;

	@Override
	public MatchTo addPointsToUsers(MatchTo matchTo, ResultTo result) {
		UserTo firstUser=matchTo.getWinner();
		firstUser.getStatistic().setPoints(result.getFirstResult());
//TODO update w DB do zorbienia
		UserTo secondUser=matchTo.getLoser();
		secondUser.getStatistic().setPoints(result.getSecondResult());
		return matchTo;
	}

	
//	@Override
//	public UserTo addPointsToUser(UserTo userTo, int points) {
//		return userDao.updatePoints(userTo, points);
//	}
}
