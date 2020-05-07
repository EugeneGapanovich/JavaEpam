package by.epam.carrental.dao;

import by.epam.carrental.entity.Order;
import by.epam.carrental.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class OrderDAO implements DAO<Order, Long> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Order entity) {
        String command = "INSERT INTO ORDERC(ORDER_ID" +
                                            ",ORDER_TIME" +
                                            ",ORDER_CARID" +
                                            ",ORDER_CLIENTID)" +
                                            " Values (?, ?, ?, ?)";
        return jdbcTemplate.update(command, entity.getId()
                                            ,entity.getTime()
                                            ,entity.getCarId()
                                            ,entity.getClientId()
        ) > 0;

    }

    @Override
    public Order read(Long key) {
        String command = "SELECT * FROM ORDERC WHERE ORDER_ID = ?";
        return jdbcTemplate.queryForObject(command, new Object[]{key}, new OrderMapper());
    }

    @Override
    public boolean update(Order entity) {
        String command = "UPDATE ORDERC SET ORDER_TIME = ?" +
                                            ",ORDER_CARID = ?" +
                                            ",ORDER_CLIENTID = ? " +
                         "WHERE ORDER_ID = ?";
        return jdbcTemplate.update(command, entity.getTime()
                                            ,entity.getCarId()
                                            ,entity.getClientId()
                                            ,entity.getId()
        ) > 0;
    }

    @Override
    public boolean delete(Long key) {
        String command = "DELETE FROM ORDERC WHERE ORDER_ID = ?";
        return jdbcTemplate.update(command, key) > 0;
    }

    @Override
    public List<Order> getAll() {
        String command = "SELECT * FROM ORDERC";
        return jdbcTemplate.query(command, new OrderMapper());
    }

}
