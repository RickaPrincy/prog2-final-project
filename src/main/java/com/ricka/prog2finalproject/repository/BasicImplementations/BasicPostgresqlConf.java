package com.ricka.prog2finalproject.repository.BasicImplementations;
import lombok.AllArgsConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BasicPostgresqlConf<T>{
    final private Class<T> type;

    /**
     * This creates a new instance of the current class using
     * the all args constructor in the class.
     * @param args : parameters that should be used in the all-args constructor
     * @return new instance
     */
    protected T createInstance(Object ...args) throws SQLException{
        Constructor<T> ctr = (Constructor<T>) Arrays.stream(this.type.getDeclaredConstructors())
                .filter(el->el.getParameterCount() > 0)
                .toArray()[0];
        try {
            return ctr.newInstance(args);
        } catch (
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException error
        ) {
            System.out.println(error.getMessage());
            throw new SQLException("Error when try to create an instance");
        }
    }

    /**
     * Returns a string that should be the table name of the current class.
     * Example: User -> "user"
     * @return tableName
     */
    protected String getTableName() {
        return "\"" + this.type.getSimpleName().toLowerCase() + "\"";
    }

    /**
     * Return all columns name except the id as string
     * ex: table(int id,name varchar(255), age int) -> "name,age"
     * @return String contain all columns
     */
    protected String getAllColumnsExceptId(){
        List<Field> fields = Arrays.stream(this.type.getDeclaredFields()).skip(1).toList();
        return fields.stream().map(Field::getName).collect(Collectors.joining(","));
    }

    protected int getFieldsLength(){
        return this.type.getDeclaredFields().length - 1;
    }

    protected String createPreparedSQL(){
        return String.join(",","?".repeat(this.getFieldsLength()).split(""));
    }

    protected String updatePreparedSQL(Object[] args,boolean acceptNull){
        StringBuilder test = new StringBuilder();
        Object[] fields = Arrays.stream(this.type.getDeclaredFields()).map(Field::getName).toArray();
        for(int i = 1; i < fields.length; i++){
            if(!acceptNull && args[i] == null)
                continue;
            test.append(fields[i]).append(" = ?, ");
        }
        test = new StringBuilder(test.substring(0, test.length() - 2) + " WHERE id = ?");
        return test.toString();
    }

    /**
     * Returns an array containing all values of a single row from the resultSet.
     * This array can be used with the createInstance("the array here") method.
     * @param resultQuery Object which contain the resultSet and the columnAccount.
     * @return An array containing all values as objects.
     */
    protected Object[] getObjectValues(ResultQuery resultQuery) throws SQLException {
        final List<Object> listOfArgs = new ArrayList<>();
        for(int i = 1; i<= resultQuery.getColumnCount(); i++){
            listOfArgs.add(resultQuery.getResultSet().getObject(i));
        }
        return listOfArgs.toArray();
    }

    protected ResultQuery getResultByQuery(Connection connection, String sql) throws SQLException {
        final ResultSet result = connection.prepareStatement(sql).executeQuery();
        final int columnCount = result.getMetaData().getColumnCount();
        return new ResultQuery(result,columnCount);
    }

    protected T getResultByUpdateDb(Connection connection, PreparedStatement statement, Object id) throws SQLException {
        final int columnAffected = statement.executeUpdate();
        if(columnAffected == 1){
            StringBuilder sqlToTakeObject= new StringBuilder("SELECT * FROM " + this.getTableName());
            if(id == null)
                sqlToTakeObject.append(" ORDER BY id DESC LIMIT 1");
            else
                sqlToTakeObject.append("WHERE id = ").append(id);
            ResultQuery resultQuery = this.getResultByQuery(connection,sqlToTakeObject.toString());
            resultQuery.getResultSet().next();
            Object[] newArgs = this.getObjectValues(resultQuery);
            return this.createInstance(newArgs);
        }
        return null;
    }
}

