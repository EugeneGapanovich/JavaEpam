
package by.epam.carrental.service;


import by.epam.carrental.dao.ClientDAO;
import by.epam.carrental.entity.Client;
import by.epam.carrental.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService extends Service<Client, Long> {

    @Autowired
    private ClientDAO controller;

    @Override
    public void create(Client entity) {
        try{
            if(!(isExist(entity))){
                controller.create(entity);
            } else{
                throw new ServiceException("SUCH CLIENT IS EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public Client read(Long key) {
        return controller.read(key);
    }

    @Override
    public void update(Client entity) {
        try{
            if(isExistByKey(entity.getId())){
                controller.update(entity);
            } else{
                throw new ServiceException("SUCH CLIENT DOES NOT EXIST");
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
                throw new ServiceException("SUCH CLIENT DOES NOT EXIST");
            }
        } catch(ServiceException e){
            log.info(e);
        }
    }

    @Override
    public List<Client> readAll() {
        return controller.getAll();
    }
}
