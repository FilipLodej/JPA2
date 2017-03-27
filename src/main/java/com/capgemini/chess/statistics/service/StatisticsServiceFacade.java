package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.MatchTo;

public interface StatisticsServiceFacade {

	/**
	 * Adds a finished match, updates user1 and user2 statistics
	 * (number of games, experience level, games lost, won, points),
	 * calculates points
	 * @param matchTo
	 * @return
	 * @throws ResultException
	 */
	 void updatePlayerStatistic(MatchTo matchTo) throws ResultException;
}
