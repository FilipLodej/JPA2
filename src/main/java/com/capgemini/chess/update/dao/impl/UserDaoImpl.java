package com.capgemini.chess.update.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.statistics.dao.impl.AbstractDao;
import com.capgemini.chess.statistics.dataaccess.entities.MatchEntity;
import com.capgemini.chess.update.dao.UserDao;
import com.capgemini.chess.update.dataaccess.entities.UserEntity;
import com.capgemini.chess.update.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.update.service.mapper.UserMapper;
import com.capgemini.chess.update.to.UserTo;
@Service
public class UserDaoImpl extends AbstractDao<UserEntity, Long> implements UserDao {


    @Override
    public UserTo update(UserTo userTo) {
        return null;
    }

    @Override
    public UserTo findByID(Long id) {
        return null;
    }

    @Override
    public UserTo updateRanking(UserEntity user) {
        return null;
    }

    @Override
    public UserTo updatePoints(UserTo userTo, int points) {
        return null;
    }
}
