package by.epam.carrental.service;

import by.epam.carrental.dao.OrderDAO;
import by.epam.carrental.entity.Order;
import by.epam.carrental.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService extends Service<Order, String> {

    @Autowired
    private OrderDAO controller;

    @Override
    public void create(Order entity) {
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
    public Order read(String key) {
        return controller.read(key);
    }

    @Override
    public void update(Order entity) {
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
    public void delete(String key) {
        try{
            if(isExistByKey(key)){
                controller.delete(key);
            } else{
                throw new ServiceException("SUCH ORDER DOES NOT EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public List<Order> readAll() {
        return controller.getAll();
    }
}
