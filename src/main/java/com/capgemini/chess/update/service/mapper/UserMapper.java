package com.capgemini.chess.update.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.update.dataaccess.entities.UserEntity;
import com.capgemini.chess.update.to.UserTo;

public class UserMapper {

	public static UserTo map(UserEntity entity) {
		if (entity != null) {
			UserTo to = new UserTo();
			to.setId(entity.getId());
			to.setLogin(entity.getLogin());
			to.setEmail(entity.getEmail());
			to.setPassword(entity.getPassword());
			to.setProfile(ProfileMapper.map(entity.getProfile()));
//			to.setStatistic(StatisticMapper.map(entity.getStatistic()));
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
			entity.setProfile(ProfileMapper.map(to.getProfile()));
//			entity.setStatistic(StatisticMapper.map(to.getStatistic()));
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
