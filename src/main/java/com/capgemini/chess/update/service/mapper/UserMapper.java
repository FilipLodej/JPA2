package com.capgemini.chess.update.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.statistics.dataaccess.entities.StatisticEntity;
import com.capgemini.chess.statistics.service.mapper.StatisticMapper;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.update.dataaccess.entities.UserEntity;
import com.capgemini.chess.update.to.ProfileTo;
import com.capgemini.chess.update.to.UserTo;

public class UserMapper {

	public static UserTo map(UserEntity entity) {
		if (entity != null) {
			UserTo to = new UserTo();
			to.setId(entity.getId());
			to.setLogin(entity.getLogin());
			to.setEmail(entity.getEmail());
			to.setPassword(entity.getPassword());
			ProfileTo profile=ProfileMapper.map(entity.getProfile());
			to.setProfile(profile);
			StatisticTo statistic=StatisticMapper.map(entity.getStatistic());
			to.setStatistic(statistic);
			return to;
		}
		return null;
	}

	public static UserEntity map(UserTo to) {
		if (to != null) {
			UserEntity entity = new UserEntity();
			entity.setId(to.getId());
			entity.setEmail(to.getEmail());
			entity.setPassword(to.getPassword());
			ProfileEntity profile=ProfileMapper.map(to.getProfile());
			entity.setProfile(profile);
			StatisticEntity statistic=StatisticMapper.map(to.getStatistic());
			entity.setStatistic(statistic);
			return entity;
		}
		return null;
	}
	


	public static List<UserTo> map2TOs(List<UserEntity> entities) {
		return entities.stream().map(UserMapper::map).collect(Collectors.toList());
	}

	public static List<UserEntity> map2Entities(List<UserTo> tos) {
		return tos.stream().map(UserMapper::map).collect(Collectors.toList());
	}
}
