package com.capgemini.chess.statistics.service.impl;

import com.capgemini.chess.statistics.service.*;
import com.capgemini.chess.statistics.service.PlayerColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.exception.ResultException;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.to.UserTo;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	PointsCalculatorService pointsCalculator;

	@Autowired
	MatchService matchService;

	@Autowired
	UserStatisticsService userStatisticsService;
	
	@Autowired
	CurrentRankingService currentRankingService;

	@Override
	public void updatePlayerStatistic(MatchTo matchTo) throws ResultException {
		// add a match
		// TODO see Interface
		matchService.addMatch(matchTo);

		// calculate points
		ResultTo whitePlayerResults = pointsCalculator.calculatePoints(PlayerColor.WHITE, matchTo);
		ResultTo blackPlayerResults = pointsCalculator.calculatePoints(PlayerColor.BLACK, matchTo);

		// update statistics player 1
		UserTo whitePlayer = matchTo.getWhitePlayer();
		userStatisticsService.updateUserStatistics(whitePlayer, whitePlayerResults);

		// update statistics player 2
		UserTo blackPlayer = matchTo.getBlackPlayer();
		userStatisticsService.updateUserStatistics(blackPlayer, blackPlayerResults);
	}

	@Override
	public List<MatchTo> showMatchHistory(UserTo userTo) throws Exception {
		return matchService.findMatchesByUser(userTo);
	}

	@Override
	public StatisticTo showUserCurrentStatistic(UserTo userTo) throws Exception {
		return userStatisticsService.showUserCurrentStatistic(userTo);
	}

	@Override
	public Long showCurrentRankingPosition(UserTo userTo) throws Exception {
		return currentRankingService.showCurrentRankingPosition(userTo);
	}





}