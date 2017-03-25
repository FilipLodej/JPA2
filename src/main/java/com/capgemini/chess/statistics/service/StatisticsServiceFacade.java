package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.update.to.UserTo;

public interface StatisticsServiceFacade {

	 UserTo updatePlayerRanking(UserTo userTo, ResultTo resultTo) throws ResultException;
	 
}
