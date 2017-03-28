package com.capgemini.chess.statistics.service.impl;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.service.PointsCalculatorService;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.service.PlayerColor;
import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.update.to.UserTo;
import org.springframework.stereotype.Service;

@Service
public class PointsCalculatorServiceImpl implements PointsCalculatorService {

	private static final int LOSS_POINTS = -10;
	private static final int VICTORY_POINTS = 10;
	private static final int DRAW_POINTS = 5;

	@Override
	public ResultTo calculatePoints(PlayerColor playerColor, MatchTo matchTo) throws ResultException {
		UserTo player = matchTo.getPlayer(playerColor);
		if (matchTo != null && player != null) {
			ResultTo result = new ResultTo();
			result.setUserTo(player);
			MatchResult matchResult = matchTo.getResult(playerColor);
			result.setScore(PointsCalculatorServiceImpl.getPoint(matchResult));
			result.setResult(matchResult);
			return result;
		} else {
			throw new ResultException("Result is incorrect");
		}
	}

	private static int getPoint(MatchResult matchResult) {
		int result = 0;
		switch (matchResult) {
		case DRAW:
			result = DRAW_POINTS;
			break;
		case WON:
			result = VICTORY_POINTS;
			break;
		case LOST:
			result = LOSS_POINTS;
			break;
		}
		return result;
	}
}
