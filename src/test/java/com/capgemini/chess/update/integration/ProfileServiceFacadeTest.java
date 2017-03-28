package com.capgemini.chess.update.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.chess.update.dao.ProfileDao;
import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.service.ProfileServiceFacade;
import com.capgemini.chess.update.to.ProfileTo;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileServiceFacadeTest {

	@Autowired
	ProfileServiceFacade profileServiceFacade;
	@Autowired
	ProfileDao profileDao;

	@Test
	public void shouldUpdateProfile() throws Exception {
		// given
		ProfileTo profileToUpdate = profileDao.findById(1L);
		String newMotto = "NoweMotto nowe motto";
		String newAbout = "nowe about nowe about";
		// when
		profileToUpdate.setLifeMotto(newMotto);
		profileToUpdate.setAboutMe(newAbout);
		ProfileTo profileAfterUpdate = profileServiceFacade.udpateProfile(profileToUpdate);
		// then
		assertEquals(newMotto, profileAfterUpdate.getLifeMotto());
		assertEquals(newAbout, profileAfterUpdate.getAboutMe());
		assertEquals(profileToUpdate.getId(),profileAfterUpdate.getId());
	}

	@Test(expected = ProfileValidationException.class)
	public void shouldThrowExceptionWhenDataAreIncorrect() throws Exception {
		// given
		ProfileTo profileToUpdate = new ProfileTo();
		// when
		profileToUpdate.setId(1L);
		profileServiceFacade.udpateProfile(profileToUpdate);
		// then
	}
}
