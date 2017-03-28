package com.capgemini.chess.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.StatisticDao;
import com.capgemini.chess.statistics.exception.UserException;
import com.capgemini.chess.statistics.service.UserStatisticsService;
import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.to.UserTo;

@Service
public class UserStatisticServiceImpl implements UserStatisticsService {

	@Autowired
	StatisticDao statisticDao;

	@Override
	public void updateUserStatistics(UserTo user, ResultTo resultTo) {
		StatisticTo userStatistic = user.getStatistic();
		MatchResult matchResult = resultTo.getResult();
		userStatistic.setPlayed(userStatistic.getPlayed()+1);
		userStatistic.setPoints(userStatistic.getPoints()+resultTo.getScore());
		userStatistic.setLevel(userStatistic.getPoints()/50);
		switch (matchResult) {
		case DRAW:
			userStatistic.setDrawn(userStatistic.getDrawn()+1);
			break;
		case WON:
			userStatistic.setWon(userStatistic.getWon()+1);
			break;
		case LOST:
			userStatistic.setLost(userStatistic.getLost()+1);
			break;
		}
		statisticDao.updateByUser(user);
	}

	@Override
	public StatisticTo showUserCurrentStatistic(UserTo userTo) throws Exception {
		if (userTo == null) {
			throw new UserException("User doesnt exists!");
		}
		return statisticDao.showCurrentUserStatistic(userTo);
	}

}
