package com.capgemini.chess.update.to;

import com.capgemini.chess.statistics.dataaccess.entities.StatisticEntity;

public class UserTo {

	private Long id;
	private String login;
	private String email;
	private String password;
	private ProfileTo profile;
	private StatisticEntity statistic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileTo getProfile() {
		return profile;
	}

	public void setProfile(ProfileTo profile) {
		this.profile = profile;
	}

	public StatisticEntity getStatistic() {
		return statistic;
	}

	public void setStatistic(StatisticEntity statistic) {
		this.statistic = statistic;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
