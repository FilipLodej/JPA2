package com.capgemini.chess.statistics.service.impl;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.StatisticsServiceFacade;
import com.capgemini.chess.statistics.service.StatisticsService;
import com.capgemini.chess.statistics.to.MatchTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceFacadeImpl implements StatisticsServiceFacade {

	@Autowired
	StatisticsService statisticsService;

	@Override
	public void updatePlayerStatistic(MatchTo matchTo) throws ResultException {
		statisticsService.updatePlayerStatistic(matchTo);
	}
}
