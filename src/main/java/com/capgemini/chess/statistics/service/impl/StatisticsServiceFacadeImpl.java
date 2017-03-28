package com.capgemini.chess.statistics.service.impl;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.StatisticsServiceFacade;
import com.capgemini.chess.statistics.service.StatisticsService;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.to.UserTo;

import java.util.List;

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

	@Override
	public List<MatchTo> showMatchHistory(UserTo userTo) throws Exception {
		return statisticsService.showMatchHistory(userTo);
	}

	@Override
	public StatisticTo showUserCurrentStatistic(UserTo userTo) throws Exception {
		return statisticsService.showUserCurrentStatistic(userTo);
	}

	@Override
	public Long showCurrentRankingPosition(UserTo userTo) throws Exception {
		return statisticsService.showCurrentRankingPosition(userTo);
	}

}
