package com.ricka.prog2finalproject.repository.BasicImplementations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicRepositoryPostgresql<T> extends BasicPostgresqlConf<T> implements BasicRepository<T> {
    final protected Connection connection;
    protected BasicRepositoryPostgresql(Connection connection, Class<T> type){
        super(type);
        this.connection = connection;
    }

    @Override
    public List<T> getAll() throws SQLException{
        final String sql = "SELECT * FROM " + this.getTableName();
        final List<T> finalResult = new ArrayList<>();
        ResultQuery resultQuery = this.getResult(this.connection,sql);
        while(resultQuery.getResultSet().next()){
            Object[] args = this.getObjectValues(resultQuery);
            finalResult.add( this.createInstance(args));
        }
        return finalResult;
    }

    @Override
    public T getById(Integer id) throws SQLException {
        final String sql = "SELECT * FROM " + this.getTableName() + " WHERE id = " + id;
        ResultQuery resultQuery = this.getResult(this.connection,sql);
        if(resultQuery.getResultSet().next()){
            Object[] args = this.getObjectValues(resultQuery);
            return this.createInstance(args);
        }
        return null;
    }
}
