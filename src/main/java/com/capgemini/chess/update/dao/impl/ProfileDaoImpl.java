package com.capgemini.chess.update.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.update.dao.ProfileDao;
import com.capgemini.chess.update.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.update.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.update.service.mapper.ProfileMapper;
import com.capgemini.chess.update.to.ProfileTo;

@Service
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	private MapDataSource dataSource;

	@Override
	public ProfileTo findById(Long id) {
		ProfileEntity profileFoundByIdEntity = dataSource.getProfile().values().stream()
				.filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		return ProfileMapper.map(profileFoundByIdEntity);
	}

	@Override
	public ProfileTo update(ProfileTo profileTo) {
		ProfileEntity profileEntity = ProfileMapper.map(profileTo);
		long profileId = profileEntity.getId();
		dataSource.getProfile().put(profileId, profileEntity);
		return ProfileMapper.map(profileEntity);

	}

}
