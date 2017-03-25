package com.capgemini.chess.statistics.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.PointsCalculatorService;
import com.capgemini.chess.statistics.to.ResultTo;
@Service
public class PointsCalculatorServiceImpl implements PointsCalculatorService {

	@Override
	public int calculatePoints(ResultTo resultTo) throws ResultException {
		int result = resultTo.getResult();
		int points = 0;
		if (result == 1) {
			points = calculateProfitPoints();
			return points;
		} else if (result == -1) {
			points = calculateLostPoints();
			return points;
		} else if (result == 0) {
			return points;
		} else {
			throw new ResultException("Result is incorrect");
		}
	}

	public int calculateProfitPoints() {
		int profitPoints = 5;
		return profitPoints;
	}

	public int calculateLostPoints() {
		int lostPoints = -5;
		return lostPoints;
	}

}
