package com.capgemini.chess.statistics.service;

import com.capgemini.chess.update.to.UserTo;

public interface UpdatePointsService {

	UserTo addPointsToUser(UserTo userTo, int points);
}
