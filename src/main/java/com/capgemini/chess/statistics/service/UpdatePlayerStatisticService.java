package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.to.UserTo;

public interface UpdatePlayerStatisticService {

	UserTo updatePlayerStatistic(MatchTo matchTo)throws ResultException;
	
}
