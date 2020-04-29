package by.epam.carrental.dao;

import by.epam.carrental.entity.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DAO<Order, String> {

    @Override
    public void create(Order entity) throws SQLException {
        try{
            String command = "INSERT INTO ORDERC Values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setLong(2, entity.getTime());
            preparedStatement.setLong(3, entity.getCarId());
            preparedStatement.setLong(4, entity.getClientId());

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("CREATED SUCCESSFULLY. ADDED ROWS: " + rows);
            } else{
                throw new SQLException("ORDER IS NOT CREATED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public void read(String key) throws SQLException {
        try{
            Order order = new Order();
            String command = "SELECT * FROM ORDERC WHERE ORDER_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                order = createOrder(rs);
            }

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("READ SUCCESSFULLY. READ ROWS: " + rows);
            } else{
                throw new SQLException("ORDER IS NOT READ");
            }

        } catch (SQLException e){
            log.info(e);
        }
    }

    @Override
    public void update(Order entity) throws SQLException {
        try{
            String command = "UPDATE ORDERC SET ORDER_TIME = ?, ORDER_CARID = ?, ORDER_CLIENTID = ? WHERE ORDER_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setLong(1, entity.getTime());
            preparedStatement.setLong(2, entity.getCarId());
            preparedStatement.setLong(3, entity.getClientId());
            preparedStatement.setLong(4, entity.getId());

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("UPDATED SUCCESSFULLY. UPDATED ROWS: " + rows);
            } else{
                throw new SQLException("ORDER IS NOT UPDATED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public void delete(String key) throws SQLException {
        try{
            String command = "DELETE FROM ORDERC WHERE ORDER_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, key);

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("DELETED SUCCESSFULLY. DELETED ROWS: " + rows);
            } else{
                throw new SQLException("ORDER IS NOT DELETED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public List<Order> getAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        try{
            String command = "SELECT * FROM ORDERC";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            ResultSet rs = preparedStatement.executeQuery(command);
            while(rs.next()){
                orders.add(createOrder(rs));
            }
        } catch (SQLException e){
            log.info(e);
        }
        return orders;
    }

    public Order createOrder(ResultSet rs){
        Order order = new Order();
        try{
            order.setId(rs.getLong("ORDER_ID"));
            order.setTime(rs.getInt("ORDER_TIME"));
            order.setCarId(rs.getLong("ORDER_CARID"));
            order.setClientId(rs.getLong("ORDER_CLIENTID"));
        } catch (SQLException e){
            log.info(e);
        }
        return order;
    }
}
