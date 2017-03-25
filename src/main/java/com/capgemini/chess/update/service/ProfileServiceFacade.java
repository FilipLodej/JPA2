package com.capgemini.chess.update.service;

import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.to.ProfileTo;

public interface ProfileServiceFacade {
	ProfileTo udpateProfile(ProfileTo profileTo) throws ProfileValidationException;
}
