package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.update.to.UserTo;

public interface UpdateRankingService {

	public UserTo updateRanking(UserTo userTo) throws ResultException;

}
