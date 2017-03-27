package com.capgemini.chess.statistics.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.PointsCalculatorService;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.ResultTo;

@Service
public class PointsCalculatorServiceImpl implements PointsCalculatorService {

	@Override
	public ResultTo calculatePoints(MatchTo matchTo) throws ResultException {
		if (matchTo != null) {
			ResultTo result = new ResultTo();
			if (matchTo.isDraw()) {
				result.setFirstResult(calculateDrawnPoints());
				result.setSecondResult(calculateDrawnPoints());
				return result;
			} else {
				result.setFirstResult(calculateProfitPoints());
				result.setSecondResult(calculateLostPoints());
				return result;
			}
		} else {
			throw new ResultException("Result is incorrect");
		}
		// int points = 0;
		// if (result == 1) {
		// points = calculateProfitPoints();
		// return points;
		// } else if (result == -1) {
		// points = calculateLostPoints();
		// return points;
		// } else if (result == 0) {
		// return points;
		// } else {
		// throw new ResultException("Result is incorrect");
		// }
	}

	public int calculateProfitPoints() {
		int profitPoints = 10;
		return profitPoints;
	}

	public int calculateLostPoints() {
		int lostPoints = -10;
		return lostPoints;
	}

	public int calculateDrawnPoints() {
		int drawnPoints = 5;
		return drawnPoints;
	}

}
