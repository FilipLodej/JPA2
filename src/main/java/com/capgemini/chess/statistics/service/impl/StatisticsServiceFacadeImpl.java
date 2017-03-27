package com.capgemini.chess.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.StatisticsServiceFacade;
import com.capgemini.chess.statistics.service.UpdatePlayerStatisticService;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.to.UserTo;
@Service
public class StatisticsServiceFacadeImpl implements StatisticsServiceFacade {

	@Autowired
	UpdatePlayerStatisticService updatePlayerStatisticService;

	@Override
	public UserTo updatePlayerStatistic(MatchTo matchTo) throws ResultException {
		return updatePlayerStatisticService.updatePlayerStatistic(matchTo);
	}
}
