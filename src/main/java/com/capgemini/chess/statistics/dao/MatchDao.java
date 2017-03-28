package com.capgemini.chess.statistics.dao;

import java.util.List;

import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.to.UserTo;

public interface MatchDao {

	MatchTo findOneTo(Long id);

	MatchTo save(MatchTo matchTo);

	List<MatchTo> findMatchesByUser(UserTo userTo);
}
