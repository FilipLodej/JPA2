package com.capgemini.chess.statistics.dao;


import com.capgemini.chess.statistics.to.MatchTo;

public interface MatchDao {
	
	MatchTo findOneTo(Long id);
	
}
