package com.capgemini.chess.update.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.update.dao.ProfileDao;
import com.capgemini.chess.update.service.ProfileValidationService;
import com.capgemini.chess.update.service.impl.ProfileUpdateServiceImpl;
import com.capgemini.chess.update.to.ProfileTo;


@RunWith(MockitoJUnitRunner.class)
public class ProfileUpdateServiceImplTest {

	@Mock
	ProfileDao profileDao;
	@Mock
	ProfileValidationService profileValidService;
	@InjectMocks
	ProfileUpdateServiceImpl profileUpdateService;

	
	@Test
	public void shouldValidateAndThenUpdateProfileAndUser() throws Exception {
		// given
		ProfileTo profileToUpdate = new ProfileTo();
		// when
		profileUpdateService.updateProfile(profileToUpdate);
		// then
		InOrder inOrder = Mockito.inOrder(profileValidService, profileDao);
		inOrder.verify(profileValidService).validate(profileToUpdate);
		inOrder.verify(profileDao).update(profileToUpdate);
	}

}
