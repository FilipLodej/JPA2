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
			UserTo whitePlayer = UserMapper.map(matchEntity.getWhitePlayer());
			UserTo blackPlayer = UserMapper.map(matchEntity.getBlackPlayer());
			matchTo.setBlackPlayer(blackPlayer);
			matchTo.setWhitePlayer(whitePlayer);
			matchTo.setBlackPlayerWon(matchEntity.isBlackPlayerWon());
			matchTo.setWhitePlayerWon(matchEntity.isWhitePlayerWon());
			return matchTo;
		}
		return null;
	}

	//TODOas above DONE
	public static MatchEntity map(MatchTo matchTo) {
		if (matchTo != null) {
			MatchEntity matchEntity = new MatchEntity();
			matchEntity.setId(matchTo.getId());
			UserEntity whitePlayer = UserMapper.map(matchTo.getWhitePlayer());
			UserEntity blackPlayer = UserMapper.map(matchTo.getBlackPlayer());
			matchEntity.setWhitePlayer(whitePlayer);
			matchEntity.setBlackPlayer(blackPlayer);
			matchEntity.setBlackPlayerWon(matchTo.isBlackPlayerWon());
			matchEntity.setWhitePlayerWon(matchTo.isWhitePlayerWon());
			return matchEntity;
		}
		return null;
	}

	//TODO same as in statistics Mapper DONE
	public static MatchEntity map(MatchEntity matchEntity, MatchTo matchTo) {
		if (matchTo != null && matchEntity!=null) {
			matchEntity.setId(matchTo.getId());
			UserEntity whitePlayer = UserMapper.map(matchTo.getWhitePlayer());
			UserEntity blackPlayer = UserMapper.map(matchTo.getBlackPlayer());
			matchEntity.setWhitePlayer(whitePlayer);
			matchEntity.setBlackPlayer(blackPlayer);
			matchEntity.setBlackPlayerWon(matchTo.isBlackPlayerWon());
			matchEntity.setWhitePlayerWon(matchTo.isWhitePlayerWon());
			return matchEntity;
		}
		return null;
	}
}
