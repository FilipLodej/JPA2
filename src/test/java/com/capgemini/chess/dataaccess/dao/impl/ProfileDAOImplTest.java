package com.capgemini.chess.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.update.dao.impl.ProfileDaoImpl;
import com.capgemini.chess.update.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.update.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.update.to.ProfileTo;

@RunWith(MockitoJUnitRunner.class)
public class ProfileDAOImplTest {
	
	private static final long EXISTING_ID = 1L;
	private static final long NOT_EXISTING_ID = 10L;

	private Map<Long, ProfileEntity> giveProfilesMap() {
		HashMap<Long, ProfileEntity> profiles = new HashMap<Long, ProfileEntity>();
		ProfileEntity profile1 = new ProfileEntity();
		profile1.setId(EXISTING_ID);
		profiles.put(EXISTING_ID, profile1);
		return profiles;
	}

	@InjectMocks
	ProfileDaoImpl profileDao;

	@Mock
	private MapDataSource dataSource;

	@Test
	public void shouldNotFindUserWhenIdDoesNotExist() {
		// given
		Mockito.when(dataSource.getProfile()).thenReturn(giveProfilesMap());

		// when
		ProfileTo profile = profileDao.findById(NOT_EXISTING_ID);

		// then
		Assert.assertNull(profile);
	}

	@Test
	public void shouldFindProfileWhenIdExist() {
		// given
		Mockito.when(dataSource.getProfile()).thenReturn(giveProfilesMap());

		// when
		ProfileTo profile = profileDao.findById(EXISTING_ID);

		// then
		Assert.assertNotNull(profile);
	} 
}
