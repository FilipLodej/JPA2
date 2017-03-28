package com.capgemini.chess.statistics.dataaccess.entities;

import javax.persistence.*;

import com.capgemini.chess.update.dataaccess.entities.UserEntity;

@Entity
@Table(name = "MATCHES")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
	UserEntity whitePlayer;

    @ManyToOne
    UserEntity blackPlayer;

    @Column(nullable = false)
    boolean whitePlayerWon;

    @Column(nullable = false)
    boolean blackPlayerWon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(UserEntity whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public UserEntity getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(UserEntity blackPlayer) {
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
}
