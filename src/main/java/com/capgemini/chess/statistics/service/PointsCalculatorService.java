package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.ResultTo;


public interface PointsCalculatorService {

	int calculatePoints(ResultTo resultTo) throws ResultException;

}
