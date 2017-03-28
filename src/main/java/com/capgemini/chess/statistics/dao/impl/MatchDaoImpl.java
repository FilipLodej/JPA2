package com.capgemini.chess.statistics.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.MatchDao;
import com.capgemini.chess.statistics.dataaccess.entities.MatchEntity;
import com.capgemini.chess.statistics.service.mapper.MatchMapper;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.to.UserTo;

@Service
public class MatchDaoImpl extends AbstractDao<MatchEntity, Long> implements MatchDao {

	@Override
	public MatchTo findOneTo(Long id) {
		MatchEntity match = findOne(id);
		return MatchMapper.map(match);
	}

	@Override
	public MatchTo save(MatchTo matchTo) {
		return MatchMapper.map(save(MatchMapper.map(matchTo)));
	}

	@Override
	public List<MatchTo> findMatchesByUser(UserTo userTo) {
		List<MatchEntity> matches = entityManager
				.createQuery("select m from MatchEntity m where m.whitePlayer.id=:id or m.blackPlayer.id=:id",
						MatchEntity.class)
				.setParameter("id", userTo.getId()).getResultList();
		return MatchMapper.map2Tos(matches);
	}
}
