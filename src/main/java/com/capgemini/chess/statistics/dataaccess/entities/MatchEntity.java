package com.capgemini.chess.statistics.dataaccess.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.chess.update.dataaccess.entities.UserEntity;

@Entity
@Table(name = "MATCHES")
public class MatchEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@ManyToOne
	UserEntity winner;
	@ManyToOne
	UserEntity loser;
	
	boolean isDraw;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getWinner() {
		return winner;
	}

	public void setWinner(UserEntity winner) {
		this.winner = winner;
	}

	public UserEntity getLoser() {
		return loser;
	}

	public void setLoser(UserEntity loser) {
		this.loser = loser;
	}

	public boolean isDraw() {
		return isDraw;
	}

	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}

}
