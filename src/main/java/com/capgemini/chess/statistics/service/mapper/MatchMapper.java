package com.capgemini.chess.statistics.service.mapper;

import com.capgemini.chess.statistics.dataaccess.entities.MatchEntity;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.dataaccess.entities.UserEntity;
import com.capgemini.chess.update.service.mapper.UserMapper;
import com.capgemini.chess.update.to.UserTo;

public class MatchMapper {

	public static MatchTo map(MatchEntity matchEntity) {
		if (matchEntity != null) {
			MatchTo matchTo = new MatchTo();
			matchTo.setId(matchEntity.getId());
			UserTo winner = UserMapper.map(matchEntity.getWinner());
			UserTo loser = UserMapper.map(matchEntity.getLoser());
			matchTo.setWinner(winner);
			matchTo.setLoser(loser);
			matchTo.setDrawn(matchEntity.isDraw());
			return matchTo;
		}
		return null;
	}
	
	public static MatchEntity map(MatchTo matchTo) {
		if (matchTo != null) {
			MatchEntity matchEntity = new MatchEntity();
			matchEntity.setId(matchTo.getId());
			UserEntity winner = UserMapper.map(matchTo.getWinner());
			UserEntity loser = UserMapper.map(matchTo.getLoser());
			matchEntity.setWinner(winner);
			matchEntity.setLoser(loser);
			matchEntity.setDraw(matchTo.isDraw());
			return matchEntity;
		}
		return null;
	}
}
