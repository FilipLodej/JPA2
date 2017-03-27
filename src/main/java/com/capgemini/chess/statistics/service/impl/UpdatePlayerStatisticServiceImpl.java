package com.capgemini.chess.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.PointsCalculatorService;
import com.capgemini.chess.statistics.service.UpdateLevelService;
import com.capgemini.chess.statistics.service.UpdatePlayerStatisticService;
import com.capgemini.chess.statistics.service.UpdatePointsService;
import com.capgemini.chess.statistics.service.UpdateRankingService;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.to.UserTo;

@Service
public class UpdatePlayerStatisticServiceImpl implements UpdatePlayerStatisticService {

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
	public UserTo updatePlayerStatistic(MatchTo matchTo) throws ResultException {
		ResultTo resultTo =pointsCalculator.calculatePoints(matchTo);
		MatchTo match=updatePointsService.addPointsToUsers(matchTo,resultTo);
//		user = updateLevelService.updatePlayerLevel(user);
//		user = updateRankingService.updateRanking(user);
		return userDao.update(user);
	}
	
}
