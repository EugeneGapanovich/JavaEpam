package by.epam.carrental.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Controller<E, K> {
    static Logger log = LogManager.getLogger();

    public abstract void create(E entity) throws SQLException;

    public abstract Optional<E> read(K key) throws SQLException;

    public abstract void update(E entity) throws SQLException;

    public abstract void delete(E entity) throws SQLException;

    public abstract List<E> getAll() throws SQLException;

    protected Connection connection;

    public Controller() {
        String dbURL = "jdbc:oracle:thin:sys/oracle@localhost:1521:carrental";
        try{
            connection = DriverManager.getConnection(dbURL);
            if(connection != null){
                log.info("CONNECTED SUCCESSFULLY " + connection);
            }
        } catch(SQLException e){
            log.info(e);
        }
    }
}
