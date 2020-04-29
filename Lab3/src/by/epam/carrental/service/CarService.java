/*

package by.epam.carrental.service;

import by.epam.carrental.dao.CarDAO;
import by.epam.carrental.entity.Car;
import by.epam.carrental.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class CarService extends Service<Car, String> {

    private CarDAO controller;

    public CarService(){
        controller = new CarDAO();
    }

    @Override
    public void create(Car entity) throws SQLException {
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
    public void read(String key) throws SQLException{
        controller.read(key);
    }

    @Override
    public void update(Car entity) throws SQLException{
        try{
            if(isExist(entity)){
                controller.create(entity);
            } else{
                throw new ServiceException("SUCH CAR DOES NOT EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public void delete(String key) throws SQLException{
        controller.delete(key);
    }

    @Override
    public List<Car> readAll() throws SQLException{
        return controller.getAll();
    }
}
*/
