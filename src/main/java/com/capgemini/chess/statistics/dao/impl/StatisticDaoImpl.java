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
		StatisticEntity statisticEntity = findOne(userTo.getId());
		return StatisticMapper.map(statisticEntity);
	}

	@Override
	public StatisticTo updateByUser(UserTo userTo) {
		StatisticTo statisticTo = userTo.getStatistic();
		return StatisticMapper.map(update(StatisticMapper.map(statisticTo)));
	}

	@Override
	public StatisticTo save(StatisticTo statisticTo) {
		return StatisticMapper.map(save(StatisticMapper.map(statisticTo)));
	}

	@Override
	public StatisticTo showCurrentUserStatistic(UserTo userTo) {
		StatisticEntity statistic = entityManager
				.createQuery("select s from StatisticEntity s where s.id=:id", StatisticEntity.class)
				.setParameter("id", userTo.getStatistic().getId()).getSingleResult();
		return StatisticMapper.map(statistic);
	}

	@Override
	public Long countCurrentUserRanking(UserTo userTo) {
		Long numberOfBetterUsers = entityManager
				.createQuery("select count(s.id)from StatisticEntity s where s.points>:points", Long.class)
				.setParameter("points", userTo.getStatistic().getPoints()).getSingleResult();
		return numberOfBetterUsers;
	}

}
