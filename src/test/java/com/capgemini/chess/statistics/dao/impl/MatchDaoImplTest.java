package com.capgemini.chess.statistics.dao.impl;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.statistics.dao.MatchDao;
import com.capgemini.chess.statistics.dao.StatisticDao;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.dao.ProfileDao;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.to.UserTo;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class MatchDaoImplTest {

	@Autowired
	MatchDao matchDao;

	@Autowired
	UserDao userDao;

	@Autowired
	StatisticDao statisticDao;

	@Autowired
	ProfileDao profileDao;

	@Test
	public void shouldSaveNewMatch() {
		// given
		UserTo user1 = userDao.findByID(1L);
		UserTo user2 = userDao.findByID(2L);
		MatchTo match = new MatchTo();
		match.setBlackPlayer(user1);
		match.setBlackPlayerWon(true);
		match.setWhitePlayer(user2);
		match.setWhitePlayerWon(false);
		// when
		MatchTo matchAfter = matchDao.save(match);
		// then
		assertEquals("pierwszy", matchAfter.getBlackPlayer().getLogin());
	}
	
}
