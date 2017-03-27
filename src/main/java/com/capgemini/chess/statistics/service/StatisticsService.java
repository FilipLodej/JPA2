package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.MatchTo;

public interface StatisticsService {

	void updatePlayerStatistic(MatchTo matchTo) throws ResultException;
	
}
