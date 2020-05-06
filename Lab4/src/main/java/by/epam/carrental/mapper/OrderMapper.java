package by.epam.carrental.mapper;

import by.epam.carrental.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    static Logger log = LogManager.getLogger();

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException{
        Order order = new Order();
        try{
            order.setId(resultSet.getLong("ORDER_ID"));
            order.setTime(resultSet.getInt("ORDER_TIME"));
            order.setCarId(resultSet.getLong("ORDER_CARID"));
            order.setClientId(resultSet.getLong("ORDER_CLIENTID"));
        } catch (SQLException e){
            log.info(e);
        }
        return order;
    }
}
