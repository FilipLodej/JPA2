package com.capgemini.chess.statistics.service;

import java.util.List;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.to.UserTo;

public interface StatisticsService {

	void updatePlayerStatistic(MatchTo matchTo) throws ResultException;

	List<MatchTo> showMatchHistory(UserTo userTo) throws Exception;
	
	StatisticTo showUserCurrentStatistic(UserTo userTo) throws Exception;
	
	Long showCurrentRankingPosition(UserTo userTo) throws Exception;
	
}
