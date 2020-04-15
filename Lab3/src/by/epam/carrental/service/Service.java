package by.epam.carrental.service;

import java.util.ArrayList;

public abstract class Service<E> {

    public abstract void create(E entity);

    public abstract void read();

    public abstract void update(E entity);

    public abstract void delete(E entity);

    public abstract void save();

    public abstract ArrayList<E> getData();
}