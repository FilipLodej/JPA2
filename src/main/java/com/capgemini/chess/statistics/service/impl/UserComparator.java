package com.capgemini.chess.statistics.service.impl;

import java.util.Comparator;

import com.capgemini.chess.update.dataaccess.entities.UserEntity;

public class UserComparator  implements Comparator<UserEntity>{

	@Override
	public int compare(UserEntity u1, UserEntity u2) {
		int result=0;
		if(u1.getStatistic().getPoints()>u2.getStatistic().getPoints()){
			result=1;
		}else if(u1.getStatistic().getPoints()<u2.getStatistic().getPoints()){
			result=-1;
		}
		return  result;
	}

}
