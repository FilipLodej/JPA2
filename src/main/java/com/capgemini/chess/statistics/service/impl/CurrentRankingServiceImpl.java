package com.capgemini.chess.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.StatisticDao;
import com.capgemini.chess.statistics.exception.UserException;
import com.capgemini.chess.statistics.service.CurrentRankingService;
import com.capgemini.chess.update.to.UserTo;

@Service
public class CurrentRankingServiceImpl implements CurrentRankingService {

	@Autowired
	StatisticDao statisticDao;

	@Override
	public Long showCurrentRankingPosition(UserTo userTo) throws Exception {
		if(userTo==null){
			throw new UserException("User doesnt exists!");
		}
		Long numberOfBetterUsers = statisticDao.countCurrentUserRanking(userTo);
		Long position = numberOfBetterUsers + 1L;
		return position;
	}
}
