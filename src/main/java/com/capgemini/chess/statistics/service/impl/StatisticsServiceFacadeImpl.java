package com.capgemini.chess.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.StatisticsServiceFacade;
import com.capgemini.chess.statistics.service.UpdatePlayerRankingService;
import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.update.to.UserTo;
@Service
public class StatisticsServiceFacadeImpl implements StatisticsServiceFacade {

	@Autowired
	UpdatePlayerRankingService updatePlayerRankingService;

	@Override
	public UserTo updatePlayerRanking(UserTo userTo, ResultTo resultTo) throws ResultException {
		return updatePlayerRankingService.updatePlayerRanking(userTo, resultTo);
	}
}
