/*
package by.epam.carrental.service;

import by.epam.carrental.dao.OrderDAO;
import by.epam.carrental.entity.Order;
import by.epam.carrental.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class OrderService extends Service<Order, String> {

    private OrderDAO controller;

    public OrderService(){
        controller = new OrderDAO();
    }

    @Override
    public void create(Order entity) throws SQLException {
        try{
            if(!(isExist(entity))){
                controller.create(entity);
            } else{
                throw new ServiceException("SUCH ORDER IS EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public void read(String key) throws SQLException {
        controller.read(key);
    }

    @Override
    public void update(Order entity) throws SQLException {
        try{
            if(isExist(entity)){
                controller.update(entity);
            } else{
                throw new ServiceException("SUCH ORDER DOES NOT EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public void delete(String key) throws SQLException {
        controller.delete(key);
    }

    @Override
    public List<Order> readAll() throws SQLException{
        return controller.getAll();
    }
}
*/
