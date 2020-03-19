package by.epam.carrental.dao;

import by.epam.carrental.entity.Client;
import by.epam.carrental.entity.User;

public class UserController extends Controller<User> {
    private static final String dir = "data/user.dat";

    @Override
    public String getDir(){
        return dir;
    }
}
