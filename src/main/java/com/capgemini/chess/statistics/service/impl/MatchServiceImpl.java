package com.capgemini.chess.statistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.MatchDao;
import com.capgemini.chess.statistics.exception.UserException;
import com.capgemini.chess.statistics.service.MatchService;
import com.capgemini.chess.statistics.to.MatchTo;
import com.capgemini.chess.update.to.UserTo;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	MatchDao matchDao;

	@Override
	public MatchTo addMatch(MatchTo matchTo) {
		return matchDao.save(matchTo);
	}

	@Override
	public List<MatchTo> findMatchesByUser(UserTo userTo) throws Exception {
		if(userTo==null){
			throw new UserException("User doesnt exists!");
		}
		return matchDao.findMatchesByUser(userTo);
	}
}
