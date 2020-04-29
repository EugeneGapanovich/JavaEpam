/*
package by.epam.carrental.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public abstract class Service<E, T> {

    static Logger log = LogManager.getLogger();

    public abstract void create(E entity) throws SQLException;

    public abstract void read(T key) throws SQLException;

    public abstract void update(E entity) throws SQLException;

    public abstract void delete(T key) throws SQLException;

    public abstract List<E> readAll() throws SQLException;

    public boolean isExist(E entity) throws SQLException{
        List<E> data = readAll();
        for(E element : data){
            if(element.hashCode() == entity.hashCode()){
                return true;
            }
        }
        return false;
    }
}
*/
