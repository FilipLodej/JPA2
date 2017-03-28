package com.capgemini.chess.update.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.service.ProfileServiceFacade;
import com.capgemini.chess.update.service.ProfileUpdateService;
import com.capgemini.chess.update.to.ProfileTo;
@Service
public class ProfileServiceFacadeImpl implements ProfileServiceFacade {

	@Autowired
	ProfileUpdateService profileUpdateService;

	@Override
	public ProfileTo udpateProfile(ProfileTo profileTo) throws ProfileValidationException {
		return profileUpdateService.updateProfile(profileTo);
	}
}
