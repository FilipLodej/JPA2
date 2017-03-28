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
public class UserStatisticServiceImpl implements UserStatisticsService{

	@Autowired
	StatisticDao statisticDao;
	
	@Override
	public void updateUserStatistics(UserTo user, ResultTo resultTo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StatisticTo showUserCurrentStatistic(UserTo userTo) throws Exception {
		if(userTo==null){
			throw new UserException("User doesnt exists!");
		}
		return statisticDao.showCurrentUserStatistic(userTo);
	}
	
}
