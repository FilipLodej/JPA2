package com.capgemini.chess.statistics.to;

import com.capgemini.chess.statistics.service.impl.MatchResult;
import com.capgemini.chess.update.to.UserTo;

public class ResultTo {

	private UserTo userTo;
	private int score;
	private MatchResult result;

	public ResultTo() {
	}

	public UserTo getUserTo() {
		return userTo;
	}

	public void setUserTo(UserTo userTo) {
		this.userTo = userTo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public MatchResult getResult() {
		return result;
	}

	public void setResult(MatchResult result) {
		this.result = result;
	}
}
