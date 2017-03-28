package com.capgemini.chess.update.dao.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.impl.AbstractDao;
import com.capgemini.chess.update.dao.ProfileDao;
import com.capgemini.chess.update.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.update.service.mapper.ProfileMapper;
import com.capgemini.chess.update.to.ProfileTo;

@Service
public class ProfileDaoImpl extends AbstractDao<ProfileEntity, Long> implements ProfileDao {

	@Override
	public ProfileTo findById(Long id) {
		ProfileEntity profileFoundByIdEntity = findOne(id);
		return ProfileMapper.map(profileFoundByIdEntity);
	}

	@Override
	public ProfileTo update(ProfileTo profileTo) {
		ProfileEntity profileEntity = ProfileMapper.map(profileTo);
		update(profileEntity);
		return ProfileMapper.map(profileEntity);

	}

}
