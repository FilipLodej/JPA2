package com.capgemini.chess.statistics.service;

import com.capgemini.chess.update.to.UserTo;

public interface CurrentRankingService {

	Long showCurrentRankingPosition(UserTo userTo) throws Exception;

}
