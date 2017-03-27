package com.capgemini.chess.statistics.to;

import com.capgemini.chess.update.to.UserTo;

public class MatchTo {

	Long id;
	UserTo winner;
	UserTo loser;
	boolean isDraw;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserTo getWinner() {
		return winner;
	}

	public void setWinner(UserTo winner) {
		this.winner = winner;
	}

	public UserTo getLoser() {
		return loser;
	}

	public void setLoser(UserTo loser) {
		this.loser = loser;
	}

	public boolean isDraw() {
		return isDraw;
	}

	public void setDrawn(boolean isDraw) {
		this.isDraw = isDraw;
	}

}
