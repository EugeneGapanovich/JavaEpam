package by.epam.carrental.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public abstract class Controller<E> {
    static Logger log = LogManager.getLogger();
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ArrayList<E> data;

    public Controller(){
        this.data = new ArrayList<E>();
    }

    public void create(E entity){
        try{
            this.data.add(entity);
            log.info(entity + " ADDED");
        } catch (Exception e) {

        }
    }

    public void read(){
        try{
            inputStream = new ObjectInputStream(new FileInputStream(getDir()));
            data = (ArrayList<E>) inputStream.readObject();
            log.info( data.size() + " OBJECTS READ SUCCESSFULLY");
            inputStream.close();
        } catch (IOException e){
            log.error(e);
        }
        catch (ClassNotFoundException e){
            log.error(e);
        }
    }

    public void update(E entity){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).hashCode() == entity.hashCode()){
                data.set(i, entity);
                log.info(data.get(i) + " UPDATE SUCCESS" );
            }
        }
    }

    public void delete(E entity){
        for(int i = 0; i < data.size(); i++) {
            if (data.get(i).hashCode() == entity.hashCode()) {
                data.remove(i);
                log.info(entity + "\n OBJECT DELETED SUCCESSFULLY");
                break;
            }
        }
    }

    public void save() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(getDir()));
            outputStream.writeObject(data);
            log.info(data.size() + " OBJECTS SAVED");
            outputStream.close();
        } catch (IOException e) {
            log.error(e);
        }
    }

    public ArrayList<E> getData() {
        return data;
    }

    public abstract String getDir();
}
