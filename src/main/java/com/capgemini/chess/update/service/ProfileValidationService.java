package com.capgemini.chess.update.service;

import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.to.ProfileTo;

public interface ProfileValidationService {

	void validate(ProfileTo profileTo) throws ProfileValidationException;
	
}
