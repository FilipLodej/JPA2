package com.capgemini.chess.statistics.dao;

import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.to.UserTo;

public interface StatisticDao {

	StatisticTo findByUser(UserTo userTo);
	StatisticTo updateByUser(UserTo userTo);
	StatisticTo save(StatisticTo statisticTo);
	StatisticTo showCurrentUserStatistic(UserTo userTo);
	Long countCurrentUserRanking(UserTo userTo);
}
