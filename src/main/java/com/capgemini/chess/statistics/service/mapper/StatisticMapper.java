package com.capgemini.chess.statistics.service.mapper;

import com.capgemini.chess.statistics.dataaccess.entities.StatisticEntity;
import com.capgemini.chess.statistics.to.StatisticTo;

public class StatisticMapper {
	public static StatisticTo map(StatisticEntity entity) {
		if (entity != null) {
			StatisticTo to = new StatisticTo();
			to.setId(entity.getId());
			to.setLevel(entity.getLevel());
			to.setPoints(entity.getPoints());
			to.setPlayed(entity.getPlayed());
			to.setWon(entity.getWon());
			to.setDrawn(entity.getDrawn());
			to.setLost(entity.getLost());
			return to;
		}
		return null;

	}

	public static StatisticEntity map(StatisticTo to) {
		if (to != null) {
			StatisticEntity entity = new StatisticEntity();
			entity.setId(to.getId());
			entity.setLevel(to.getLevel());
			entity.setPoints(to.getPoints());
			entity.setPlayed(to.getPlayed());
			entity.setWon(to.getWon());
			entity.setDrawn(to.getDrawn());
			entity.setLost(to.getLost());
			return entity;
		}
		return null;
	}

	public static StatisticEntity map(StatisticEntity entity, StatisticTo to) {
		if (entity != null && to != null) {
			entity.setId(to.getId());
			entity.setLevel(to.getLevel());
			entity.setPoints(to.getPoints());
			entity.setPlayed(to.getPlayed());
			entity.setWon(to.getWon());
			entity.setDrawn(to.getDrawn());
			entity.setLost(to.getLost());
			return entity;
		}
		return null;
	}
}
