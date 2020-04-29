package by.epam.carrental.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<E, T> {

    static Logger log = LogManager.getLogger();

    public abstract void create(E entity) throws SQLException;

    public abstract void read(T key) throws SQLException;

    public abstract void update(E entity) throws SQLException;

    public abstract void delete(T key) throws SQLException;

    public abstract List<E> getAll() throws SQLException;

    protected Connection connection;

    public DAO() {
        String url = "jdbc:oracle:thin:eugene/oracle@localhost:1521:orcl";
        try{
            connection = DriverManager.getConnection(url);
            if(connection != null){
                log.info("CONNECTED SUCCESSFULLY " + connection);
            }
        } catch(SQLException e){
            log.info(e);
        }
    }
}
