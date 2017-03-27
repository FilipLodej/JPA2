package com.capgemini.chess.statistics.service;

import java.util.List;

import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.to.UserTo;

public interface MatchService {

    //TODO create service impl, matchDAO to insert Match entity (save)
    //TODO MatchDAO - also create which will find all matches for user (where user_id = white player or user_id= black player)
    void addMatch(MatchTo match);
    List<MatchTo> findAll(UserTo userTo);
}
