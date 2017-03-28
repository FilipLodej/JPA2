package com.capgemini.chess.statistics.dao.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.StatisticDao;
import com.capgemini.chess.statistics.dataaccess.entities.StatisticEntity;
import com.capgemini.chess.statistics.service.mapper.StatisticMapper;
import com.capgemini.chess.statistics.to.StatisticTo;
import com.capgemini.chess.update.to.UserTo;

@Service
public class StatisticDaoImpl extends AbstractDao<StatisticEntity, Long> implements StatisticDao {

	@Override
	public StatisticTo findByUser(UserTo userTo) {
		StatisticEntity statisticEntity=findOne(userTo.getId());
		return StatisticMapper.map(statisticEntity);
	}

	@Override
	public StatisticTo updateByUser(UserTo userTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatisticTo save(StatisticTo statisticTo) {
		return StatisticMapper.map(save(StatisticMapper.map(statisticTo)));
	}

	
}
