package by.epam.carrental.dao;


import java.util.List;

public interface DAO<E, T> {

    boolean create(E entity);
    E read(T key);
    boolean update(E entity);
    boolean delete(T key);
    List<E> getAll();

}
