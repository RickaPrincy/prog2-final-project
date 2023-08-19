package com.ricka.prog2finalproject.repository;
import lombok.AllArgsConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BasicPostgresqlConf<T>{
    final private Class<T> type;

    /**
     * This creates a new instance of the current class using
     * the first constructor found in the class.
     * In my case, it's the all-args constructor.
     * @param args : parameters that should be used in the all-args constructor
     * @return new instance
     */
    protected T createInstance(Object ...args) throws SQLException{
        Constructor<T> ctr = (Constructor<T>) this.type.getDeclaredConstructors()[0];
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
     * Returns an array containing all values of a single row from the resultSet.
     * This array can be used with the createInstance("the array here") method.
     * @param columnCount The number of columns in the table.
     * @param resultSet The ResultSet containing the values.
     * @return An array containing all values as objects.
     */
    protected Object[] getObjectValues(int columnCount, ResultSet resultSet) throws SQLException {
        final List<Object> listOfArgs = new ArrayList<>();
        for(int i = 1; i<= columnCount; i++){
            listOfArgs.add(resultSet.getObject(i));
        }
        return listOfArgs.toArray();
    }
}

