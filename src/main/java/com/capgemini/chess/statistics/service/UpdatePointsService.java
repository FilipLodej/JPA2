package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.ResultTo;


public interface UpdatePointsService {

	MatchTo addPointsToUsers(MatchTo matchTo, ResultTo result);
}
