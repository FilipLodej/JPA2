package com.capgemini.chess.statistics.service;

import java.util.List;

import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.to.UserTo;

public interface MatchService {

    MatchTo addMatch(MatchTo matchTo);
    List<MatchTo> findMatchesByUser(UserTo userTo) throws Exception;
}
