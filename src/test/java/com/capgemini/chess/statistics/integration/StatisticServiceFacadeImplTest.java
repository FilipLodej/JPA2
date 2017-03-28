package com.capgemini.chess.statistics.integration;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.chess.statistics.dao.MatchDao;
import com.capgemini.chess.statistics.dao.StatisticDao;
import com.capgemini.chess.statistics.exception.ResultException;
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
	
	@Autowired
	EntityManager em;

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
		assertEquals("pierwszy", matchDao.findOneTo(8L).getBlackPlayer().getLogin());
		assertEquals("drugi", matchDao.findOneTo(8L).getWhitePlayer().getLogin());
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
	

	@Test
	public void shouldUpdateUsersStatisticsAfterWonMatch() throws Exception{
		//given
		UserTo user1 = userDao.findByID(1L);
		UserTo user2 = userDao.findByID(2L);
		int user1Points=user1.getStatistic().getPoints();
		int user2Points=user2.getStatistic().getPoints();
		int user1Won=user1.getStatistic().getWon();
		int user2Lost=user2.getStatistic().getLost();
		int user1Played=user1.getStatistic().getPlayed();
		int user2Played=user2.getStatistic().getPlayed();	
		MatchTo match = new MatchTo();
		match.setBlackPlayer(user1);
		match.setBlackPlayerWon(true);
		match.setWhitePlayer(user2);
		match.setWhitePlayerWon(false);
		//when
		statisticsServiceFacade.updatePlayerStatistic(match);
		em.flush();
		UserTo afterUpdate1=userDao.findByID(1L);
		UserTo afterUpdate2=userDao.findByID(2L);
		int after1Points=afterUpdate1.getStatistic().getPoints();
		int after2Points=afterUpdate2.getStatistic().getPoints();
		int after1Won=afterUpdate1.getStatistic().getWon();
		int after2Lost=afterUpdate2.getStatistic().getLost();
		int after1Played=afterUpdate1.getStatistic().getPlayed();
		int after2Played=afterUpdate2.getStatistic().getPlayed();
		StatisticTo stat1After=afterUpdate1.getStatistic();
		StatisticTo stat2After=afterUpdate2.getStatistic();
		//then
		assertEquals(user1Points+10,after1Points);
		assertEquals(user2Points-10,after2Points);
		assertEquals(user1Won+1,after1Won);
		assertEquals(user2Lost+1, after2Lost);
		assertEquals(user1Played+1,after1Played);
		assertEquals(user2Played+1, after2Played);
		assertEquals(user1.getStatistic().getPoints()/50, afterUpdate1.getStatistic().getLevel());
		assertEquals(user2.getStatistic().getPoints()/50,afterUpdate2.getStatistic().getLevel());
	}

	@Test
	public void shouldUpdateUsersStatisticsAfterDrawnMatch() throws ResultException{
		//given
		UserTo user1 = userDao.findByID(1L);
		UserTo user2 = userDao.findByID(2L);
		int user1Points=user1.getStatistic().getPoints();
		int user2Points=user2.getStatistic().getPoints();
		int user1Drawn=user1.getStatistic().getDrawn();
		int user2Drawn=user2.getStatistic().getDrawn();
		int user1Played=user1.getStatistic().getPlayed();
		int user2Played=user2.getStatistic().getPlayed();	
		MatchTo match = new MatchTo();
		match.setBlackPlayer(user1);
		match.setBlackPlayerWon(true);
		match.setWhitePlayer(user2);
		match.setWhitePlayerWon(true);
		//when
		statisticsServiceFacade.updatePlayerStatistic(match);
		em.flush();
		UserTo afterUpdate1=userDao.findByID(1L);
		UserTo afterUpdate2=userDao.findByID(2L);
		int after1Points=afterUpdate1.getStatistic().getPoints();
		int after2Points=afterUpdate2.getStatistic().getPoints();
		int after1Drawn=afterUpdate1.getStatistic().getDrawn();
		int after2Drawn=afterUpdate2.getStatistic().getDrawn();
		int after1Played=afterUpdate1.getStatistic().getPlayed();
		int after2Played=afterUpdate2.getStatistic().getPlayed();
		StatisticTo stat1After=afterUpdate1.getStatistic();
		StatisticTo stat2After=afterUpdate2.getStatistic();
		//then
		assertEquals(user1Points+5,after1Points);
		assertEquals(user2Points+5,after2Points);
		assertEquals(user1Drawn+1,after1Drawn);
		assertEquals(user2Drawn+1, after2Drawn);
		assertEquals(user1Played+1,after1Played);
		assertEquals(user2Played+1, after2Played);
		assertEquals(user1.getStatistic().getPoints()/50, afterUpdate1.getStatistic().getLevel());
		assertEquals(user2.getStatistic().getPoints()/50,afterUpdate2.getStatistic().getLevel());
	}

}
