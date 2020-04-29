/*

package by.epam.carrental.service;


import by.epam.carrental.dao.ClientDAO;
import by.epam.carrental.entity.Client;
import by.epam.carrental.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class ClientService extends Service<Client, String> {

    private ClientDAO controller;

    public  ClientService(){
        controller = new ClientDAO();
    }

    @Override
    public void create(Client entity) throws SQLException {
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
    public void read(String key) throws SQLException {
        controller.read(key);
    }

    @Override
    public void update(Client entity) throws SQLException {
        try{
            if(isExist(entity)){
                controller.update(entity);
            } else{
                throw new ServiceException("SUCH CLIENT DOES NOT EXIST");
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
    public List<Client> readAll() throws SQLException{
        return controller.getAll();
    }
}
*/
