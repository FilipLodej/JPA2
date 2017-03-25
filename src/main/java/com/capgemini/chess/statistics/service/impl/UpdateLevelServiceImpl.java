package com.capgemini.chess.statistics.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.service.UpdateLevelService;
import com.capgemini.chess.update.to.UserTo;
@Service
public class UpdateLevelServiceImpl implements UpdateLevelService {


	
	@Override
	public UserTo updatePlayerLevel(UserTo userTo) {
		int currentLevel=calculateLevel(userTo);
		userTo.getStatistic().setLevel(currentLevel);
		return userTo;
	}
	
	int calculateLevel(UserTo userTo){
		int points=userTo.getStatistic().getPoints();
		int calculatedLevel=points/10;
	return calculatedLevel;
	}

}
