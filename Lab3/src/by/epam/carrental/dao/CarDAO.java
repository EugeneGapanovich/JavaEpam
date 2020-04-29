package by.epam.carrental.dao;

import by.epam.carrental.entity.Car;
import by.epam.carrental.exception.CarException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends DAO<Car, String> {

    @Override
    public void create(Car entity) throws SQLException {
        try{
            String command = "INSERT INTO CAR Values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getModel());
            preparedStatement.setInt(3, entity.getYearOfCar());
            preparedStatement.setBigDecimal(4, entity.getPrice());
            preparedStatement.setLong(5, entity.getId());

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("CREATED SUCCESSFULLY. ADDED ROWS: " + rows);
            } else{
               throw new SQLException("CAR IS NOT CREATED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public void read(String key) throws SQLException{
        try{
            Car car = new Car();
            String command = "SELECT * FROM CAR WHERE CAR_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                car = createCar(rs);
            }
            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("READ SUCCESSFULLY. READ ROWS: " + rows);
            } else{
                throw new SQLException("CAR IS NOT READ");
            }
        } catch (SQLException e){
            log.info(e);
        }
    }

    @Override
    public void update(Car entity) throws SQLException {
        try{
           String command = "UPDATE CAR SET CAR_NAME = ?, CAR_MODEL = ?, CAR_YEAR = ?, CAR_PRICE = ? WHERE CAR_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getModel());
            preparedStatement.setInt(3, entity.getYearOfCar());
            preparedStatement.setBigDecimal(4, entity.getPrice());
            preparedStatement.setLong(5, entity.getId());

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("UPDATED SUCCESSFULLY. UPDATED ROWS: " + rows);
            } else{
                throw new SQLException("CAR IS NOT UPDATED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public void delete(String key) throws SQLException {
       try{
           String command = "DELETE FROM CAR WHERE CAR_ID = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(command);
           preparedStatement.setString(1, key);

           Integer rows = preparedStatement.executeUpdate();
           if(rows > 0){
               log.info("DELETED SUCCESSFULLY. DELETED ROWS: " + rows);
           } else{
               throw new SQLException("CAR IS NOT DELETED");
           }
       } catch(SQLException e){
           log.info(e);
       }
    }

    @Override
    public List<Car> getAll() throws SQLException{
        List<Car> cars = new ArrayList<>();
        try{
            String command = "SELECT * FROM CAR";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            ResultSet rs = preparedStatement.executeQuery(command);
            while(rs.next()){
                cars.add(createCar(rs));
            }
        } catch (SQLException e){
            log.info(e);
        }
        return cars;
    }

    public Car createCar(ResultSet rs){
        Car car = new Car();
        try{
            car.setName(rs.getString("CAR_NAME"));
            car.setModel(rs.getString("CAR_MODEL"));
            car.setYearOfCar(rs.getInt("CAR_YEAR"));
            car.setPrice(rs.getBigDecimal("CAR_PRICE"));
            car.setId(rs.getLong("CAR_ID"));
        } catch (SQLException e){
            log.info(e);
        } catch (CarException e){
            log.info(e);
        }
        return car;
    }
}
