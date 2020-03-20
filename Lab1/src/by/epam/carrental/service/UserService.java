package by.epam.carrental.service;


import by.epam.carrental.dao.UserController;
import by.epam.carrental.entity.User;

import java.util.ArrayList;

public class UserService extends Service<User>{

    private UserController controller;

    public  UserService(){
        controller = new UserController();
    }

    @Override
    public void create(User entity) {
        controller.create(entity);
    }

    @Override
    public void read() {
        controller.read();
    }

    @Override
    public void update(User entity) {
        controller.update(entity);
    }

    @Override
    public void delete(User entity) {
        controller.delete(entity);
    }

    @Override
    public void save() {
        controller.save();
    }

    @Override
    public ArrayList<User> getData() {
        return controller.getData();
    }
}
