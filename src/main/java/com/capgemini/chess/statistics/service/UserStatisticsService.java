package com.capgemini.chess.statistics.service;

import com.capgemini.chess.statistics.to.ResultTo;
import com.capgemini.chess.update.to.UserTo;

public interface UserStatisticsService {

    /**
     * Should update all user statistics: level, matches number (lost, won, draw), points
     * @param user
     * @param resultTo
     */
    //TODO  implement - find user by id, get his statistics and update, then save user (cascades)
    void updateUserStatistics(UserTo user, ResultTo resultTo);
}
