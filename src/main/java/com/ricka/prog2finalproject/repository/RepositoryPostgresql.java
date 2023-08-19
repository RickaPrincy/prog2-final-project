package com.ricka.prog2finalproject.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryPostgresql<T> extends RepositoryPostgresqlConf<T> implements Repository<T>{
    final private Connection connection;
    protected RepositoryPostgresql(Connection connection,Class<T> type){
        super(type);
        this.connection = connection;
    }

    @Override
    public List<T> getAll() {
        final String sql = "SELECT * FROM " + this.getTableName();
        final List<T> finalResult = new ArrayList<>();

        try {
            final ResultSet result = connection.prepareStatement(sql).executeQuery();
            final int columnCount = result.getMetaData().getColumnCount();
            while(result.next()){
                Object[] args = this.getObjectValues(columnCount,result);
                finalResult.add( this.createInstance(args));
            }
            return finalResult;
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return null;
    }
}
