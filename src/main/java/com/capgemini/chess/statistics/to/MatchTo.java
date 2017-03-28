package com.capgemini.chess.statistics.to;

import com.capgemini.chess.statistics.service.PlayerColor;
import com.capgemini.chess.statistics.service.impl.MatchResult;
import com.capgemini.chess.update.to.UserTo;

public class MatchTo {

	Long id;
	UserTo whitePlayer;
	UserTo blackPlayer;
	boolean whitePlayerWon;
	boolean blackPlayerWon;

	public MatchTo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserTo getWhitePlayer() {
		return whitePlayer;
	}

	public void setWhitePlayer(UserTo whitePlayer) {
		this.whitePlayer = whitePlayer;
	}

	public UserTo getBlackPlayer() {
		return blackPlayer;
	}

	public void setBlackPlayer(UserTo blackPlayer) {
		this.blackPlayer = blackPlayer;
	}

	public boolean isWhitePlayerWon() {
		return whitePlayerWon;
	}

	public void setWhitePlayerWon(boolean whitePlayerWon) {
		this.whitePlayerWon = whitePlayerWon;
	}

	public boolean isBlackPlayerWon() {
		return blackPlayerWon;
	}

	public void setBlackPlayerWon(boolean blackPlayerWon) {
		this.blackPlayerWon = blackPlayerWon;
	}

	public boolean isDraw() {
		return whitePlayerWon == blackPlayerWon;
	}

	public MatchResult getResult(PlayerColor playerColor){
		MatchResult result;
		if(isDraw()){
			result = MatchResult.DRAW;
		} else if( (PlayerColor.WHITE.equals(playerColor) && whitePlayerWon) ||  (PlayerColor.BLACK.equals(playerColor) && blackPlayerWon)){
			result = MatchResult.WON;
		} else {
			result = MatchResult.LOST;
		}
		return result;
	}

	public UserTo getPlayer(PlayerColor playerColor){
		if(PlayerColor.BLACK.equals(playerColor)){
			return getBlackPlayer();
		} else {
			return getWhitePlayer();
		}
	}


}
