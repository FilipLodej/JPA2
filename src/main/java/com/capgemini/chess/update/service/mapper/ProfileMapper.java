package com.capgemini.chess.update.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.update.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.update.to.ProfileTo;

public class ProfileMapper {

	public static ProfileTo map(ProfileEntity entity) {
		if (entity != null) {
			ProfileTo to = new ProfileTo();
			to.setId(entity.getId());
			to.setName(entity.getName());
			to.setSurname(entity.getSurname());
			to.setAboutMe(entity.getAboutMe());
			to.setLifeMotto(entity.getLifeMotto());
			return to;
		}
		return null;
	}

	public static ProfileEntity map(ProfileTo to) {
		if (to != null) {
			ProfileEntity entity = new ProfileEntity();
			entity.setId(to.getId());
			entity.setName(to.getName());
			entity.setSurname(to.getSurname());
			entity.setAboutMe(to.getAboutMe());
			entity.setLifeMotto(to.getLifeMotto());
			return entity;
		}
		return null;
	}

	public static List<ProfileTo> map2TOs(List<ProfileEntity> entities) {
		return entities.stream().map(ProfileMapper::map).collect(Collectors.toList());
	}

	public static List<ProfileEntity> map2Entities(List<ProfileTo> tos) {
		return tos.stream().map(ProfileMapper::map).collect(Collectors.toList());
	}
}
