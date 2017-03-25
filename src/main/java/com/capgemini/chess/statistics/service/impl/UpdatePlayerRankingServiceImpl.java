package com.capgemini.chess.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.PointsCalculatorService;
import com.capgemini.chess.statistics.service.UpdateLevelService;
import com.capgemini.chess.statistics.service.UpdatePlayerRankingService;
import com.capgemini.chess.statistics.service.UpdatePointsService;
import com.capgemini.chess.statistics.service.UpdateRankingService;
import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.to.UserTo;

@Service
public class UpdatePlayerRankingServiceImpl implements UpdatePlayerRankingService {

	@Autowired
	PointsCalculatorService pointsCalculator;

	@Autowired
	UpdatePointsService updatePointsService;

	@Autowired
	UpdateLevelService updateLevelService;

	@Autowired
	UserDao userDao;
	
	@Autowired
	UpdateRankingService updateRankingService;

	@Override
	public UserTo updatePlayerRanking(UserTo userTo, ResultTo resultTo) throws ResultException {
		int points=pointsCalculator.calculatePoints(resultTo);
		UserTo user=updatePointsService.addPointsToUser(userTo, points);
		user = updateLevelService.updatePlayerLevel(user);
		user = updateRankingService.updateRanking(user);
		return userDao.update(user);
	}
	
}
