
package by.epam.carrental.service;

import by.epam.carrental.dao.CarDAO;
import by.epam.carrental.entity.Car;
import by.epam.carrental.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService extends Service<Car, Long> {

    @Autowired
    private CarDAO controller;

    @Override
    public void create(Car entity){
        try{
            if(!(isExist(entity))){
                controller.create(entity);
            } else{
                throw new ServiceException("SUCH CAR IS EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public Car read(Long key) {
        return controller.read(key);
    }

    @Override
    public void update(Car entity) {
        try{
            if(isExistByKey(entity.getId())){
                controller.update(entity);
            } else{
                throw new ServiceException("SUCH CAR DOES NOT EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public void delete(Long key) {
        try{
            if(isExistByKey(key)){
                controller.delete(key);
            } else{
                throw new ServiceException("SUCH CAR DOES NOT EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public List<Car> readAll() {
        return controller.getAll();
    }
}
