package com.capgemini.chess.statistics.dao.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.MatchDao;
import com.capgemini.chess.statistics.dataaccess.entities.MatchEntity;
import com.capgemini.chess.statistics.service.mapper.MatchMapper;
import com.capgemini.chess.statistics.to.MatchTo;
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

}
