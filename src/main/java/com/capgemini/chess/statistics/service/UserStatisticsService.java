package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.to.UserTo;

public interface UserStatisticsService {

	/**
	 * Should update all user statistics: level, matches number (lost, won,
	 * draw), points
	 * Should show current user statistics
	 * @param user
	 * @param resultTo
	 */
	void updateUserStatistics(UserTo user, ResultTo resultTo);

	StatisticTo showUserCurrentStatistic(UserTo userTo) throws Exception;
}
