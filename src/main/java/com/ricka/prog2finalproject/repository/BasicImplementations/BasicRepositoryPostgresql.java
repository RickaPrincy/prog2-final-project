package com.ricka.prog2finalproject.repository.BasicImplementations;

import com.ricka.prog2finalproject.service.ResponseError;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        ResultQuery resultQuery = this.getResultByQuery(this.connection,sql);
        while(resultQuery.getResultSet().next()){
            Object[] args = this.getObjectValues(resultQuery);
            finalResult.add( this.createInstance(args));
        }
        return finalResult;
    }

    @Override
    public T getById(Integer id) throws SQLException {
        final String sql = "SELECT * FROM " + this.getTableName() + " WHERE id = " + id;
        ResultQuery resultQuery = this.getResultByQuery(this.connection,sql);

        if(resultQuery.getResultSet().next()){
            Object[] args = this.getObjectValues(resultQuery);
            return this.createInstance(args);
        }
        return null;
    }
    @Override
    public T deleteById(Integer id) throws SQLException {
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE id = " + id;
        ResultQuery resultQuery = this.getResultByQuery(connection,sql);

        if(resultQuery.getResultSet().next()){
            Object[] args = this.getObjectValues(resultQuery);
            T objectAffected = this.createInstance(args);
            String sqlToDelete = "DELETE FROM " + this.getTableName() + " WHERE id = " + id;
            connection.prepareStatement(sqlToDelete).executeUpdate();
            return  objectAffected ;
        }
        return null;
    }

    @Override
    public T create(Object[] args) throws SQLException {
        String sql =
                "INSERT INTO " + this.getTableName() + " (" +
                this.getAllColumnsExceptId() + ") VALUES " +
                "(" + this.getPreparedValues() + ")";

        PreparedStatement statement = this.connection.prepareStatement(sql);
        for(int i = 1; i <= this.getFieldsLength(); i++){
            statement.setObject(i,args[i - 1]);
        }
        return this.getResultByUpdate(connection,statement);
    }

    @Override
    public T update(Object[] args) throws SQLException {
        String sql =
            " UPDATE " + this.getTableName() +
            " SET " + this.getPreparedUpdate(args);
        PreparedStatement statement = this.connection.prepareStatement(sql);
        for(int i = 1; i <= this.getFieldsLength(); i++){
            statement.setObject(i,args[i]);
        }
        statement.setObject(this.getFieldsLength() + 1, args[0]);
        return this.getResultByUpdate(connection,statement);
    }
}
