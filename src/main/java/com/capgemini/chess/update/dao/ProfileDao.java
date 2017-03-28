package com.capgemini.chess.update.dao;

import com.capgemini.chess.update.to.ProfileTo;

public interface ProfileDao {

	ProfileTo findById(Long id);
	ProfileTo update(ProfileTo profileTo);
}
