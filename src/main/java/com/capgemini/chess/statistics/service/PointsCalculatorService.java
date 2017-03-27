package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.ResultTo;



public interface PointsCalculatorService {

	/**
	 * Calculates points for victory, defeat and draw.
	 * @param matchTo
	 * @return
	 * @throws ResultException
	 */
	ResultTo calculatePoints(PlayerColor playerColor, MatchTo matchTo) throws ResultException;

}
