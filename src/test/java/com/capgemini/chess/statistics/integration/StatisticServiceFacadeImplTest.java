package com.capgemini.chess.statistics.integration;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.chess.statistics.dao.MatchDao;
import com.capgemini.chess.statistics.dao.StatisticDao;
import com.capgemini.chess.statistics.exception.UserException;
import com.capgemini.chess.statistics.service.MatchService;
import com.capgemini.chess.statistics.service.StatisticsServiceFacade;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.dao.ProfileDao;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.to.UserTo;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticServiceFacadeImplTest {

	@Autowired
	StatisticsServiceFacade statisticsServiceFacade;

	@Autowired
	MatchService matchService;

	@Autowired
	MatchDao matchDao;

	@Autowired
	UserDao userDao;

	@Autowired
	StatisticDao statisticDao;

	@Autowired
	ProfileDao profileDao;

	@Test
	public void shouldAddNewMatch() throws Exception {
		// given
		UserTo user1 = userDao.findByID(1L);
		UserTo user2 = userDao.findByID(2L);
		MatchTo match = new MatchTo();
		match.setBlackPlayer(user1);
		match.setBlackPlayerWon(true);
		match.setWhitePlayer(user2);
		match.setWhitePlayerWon(false);
		// when
		statisticsServiceFacade.updatePlayerStatistic(match);
		// then
		assertEquals("pierwszy", matchDao.findOneTo(6L).getBlackPlayer().getLogin());
		assertEquals("drugi", matchDao.findOneTo(6L).getWhitePlayer().getLogin());
	}

	@Test
	public void shouldReturnHistoryOfUserMatches() throws Exception {
		// given
		UserTo user1 = userDao.findByID(3L);
		// when
		List<MatchTo> matches = statisticsServiceFacade.showMatchHistory(user1);
		// then
		assertFalse(matches.isEmpty());
		for (MatchTo m : matches) {
			assertTrue(3L == m.getWhitePlayer().getId() || 3L == m.getBlackPlayer().getId());
		}
	}

	@Test(expected = UserException.class)
	public void shouldThrowExceptionHistoryOfUserMatchesWhenUserDoesntExists() throws Exception {
		// given
		UserTo user1 = null;
		// when
		statisticsServiceFacade.showMatchHistory(user1);
		// then
	}

	@Test
	public void shouldReturnUserCurrentStatistic() throws Exception {
		// given
		UserTo user1 = userDao.findByID(3L);
		// when
		StatisticTo statistic = statisticsServiceFacade.showUserCurrentStatistic(user1);
		// then
		assertNotNull(statistic);
		assertEquals(user1.getStatistic().getId(), statistic.getId());
	}

	@Test(expected = UserException.class)
	public void shouldThrowExceptionWhenUserToCurrentStatisticDesntExists() throws Exception {
		// given
		UserTo user1 = null;
		// when
		statisticsServiceFacade.showUserCurrentStatistic(user1);
		// then

	}

	@Test
	public void shouldReturnUserCurrentRankingPosition() throws Exception {
		// given
		UserTo user1 = userDao.findByID(3L);
		Long expectedPosition = 5L;
		// when
		Long position = statisticsServiceFacade.showCurrentRankingPosition(user1);
		// then
		assertEquals(expectedPosition, position);
	}

	@Test(expected = UserException.class)
	public void shouldThrowExceptionWhenUserDoesntExistToCurrentRankingPosition() throws Exception {
		// given
		UserTo user1 = null;
		// when
		statisticsServiceFacade.showCurrentRankingPosition(user1);
		// then
	}

}
