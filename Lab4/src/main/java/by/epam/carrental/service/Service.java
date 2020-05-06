package by.epam.carrental.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;

import java.util.List;

public abstract class Service<E, T> {

    static Logger log = LogManager.getLogger();

    public abstract void create(E entity);
    public abstract E read(T key);
    public abstract void update(E entity);
    public abstract void delete(T key);
    public abstract List<E> readAll();

    public boolean isExist(E entity){
        try{
            List<E> data = readAll();
            for(E element : data){
                if(element.hashCode() == entity.hashCode()){
                    return true;
                }
            }
        } catch (DataAccessException e){
            log.info(e);
        }
        return false;
    }

    public boolean isExistByKey(T key){
        try{
            E entity = read(key);
        } catch (DataAccessException e){
            log.info(e);
            return false;
        }
        return true;
    }

}
