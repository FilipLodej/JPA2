package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.ResultTo;



public interface PointsCalculatorService {

	ResultTo calculatePoints(MatchTo matchTo) throws ResultException;

}
