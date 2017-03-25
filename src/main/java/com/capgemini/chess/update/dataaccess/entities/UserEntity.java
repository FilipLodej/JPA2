package com.capgemini.chess.update.dataaccess.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capgemini.chess.statistics.dataaccess.entities.StatisticEntity;

@Entity
@Table(name = "USER")
public class UserEntity extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 10)
	private String login;	
	@Column(nullable = false, length = 10)
	private String email;
	@Column(nullable = false, length = 10)
	private String password;
	@OneToOne
	private ProfileEntity profile;
	@OneToOne
	private StatisticEntity statistic;

	public UserEntity(){
	}
	
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

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
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
