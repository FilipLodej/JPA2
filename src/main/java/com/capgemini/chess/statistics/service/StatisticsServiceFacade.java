package com.capgemini.chess.statistics.service;

import java.util.List;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.to.UserTo;

public interface StatisticsServiceFacade {

	/**
	 * Adds a finished match, updates user1 and user2 statistics
	 * (number of games, experience level, games lost, won, points),
	 * calculates points
	 * 
	 *should show current user ranking position
	 * @param matchTo
	 * @return
	 * @throws ResultException
	 */
	 void updatePlayerStatistic(MatchTo matchTo) throws ResultException;
	 List<MatchTo> showMatchHistory(UserTo userTo) throws Exception;
	 StatisticTo showUserCurrentStatistic(UserTo userTo) throws Exception;
	 Long showCurrentRankingPosition(UserTo userTo) throws Exception;
	 
}
