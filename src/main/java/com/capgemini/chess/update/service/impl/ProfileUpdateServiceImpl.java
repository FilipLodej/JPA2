package com.capgemini.chess.update.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.update.dao.ProfileDao;
import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.service.ProfileUpdateService;
import com.capgemini.chess.update.service.ProfileValidationService;
import com.capgemini.chess.update.to.ProfileTo;

@Service
public class ProfileUpdateServiceImpl implements ProfileUpdateService {

	@Autowired
	ProfileValidationService profileValidService;

	@Autowired
	ProfileDao profileDao;

	@Override
	public ProfileTo updateProfile(ProfileTo profileTo) throws ProfileValidationException {
		profileValidService.validate(profileTo);
		return profileDao.update(profileTo);
	}

}
