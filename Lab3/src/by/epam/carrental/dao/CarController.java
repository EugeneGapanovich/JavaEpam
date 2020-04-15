package by.epam.carrental.dao;

import by.epam.carrental.entity.Car;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarController extends Controller<Car, String> {
    @Override
    public void create(Car entity) throws SQLException {
        try{
            String sql = "INSERT INTO CAR (CAR_NAME, CAR_MODEL, CAR_YEAR, CAR_PRICE, CAR_ID) Values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getModel());
            preparedStatement.setInt(3, entity.getYearOfCar());
            preparedStatement.setBigDecimal(4, entity.getPrice());
            preparedStatement.setLong(5, entity.getId());

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("CREATED SUCCESSFULLY");
            } else{
                throw new SQLException("ENTITY IS NOT CREATED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public Optional<Car> read(String key) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void update(Car entity) throws SQLException {
    }

    @Override
    public void delete(Car entity) throws SQLException {
    }

    @Override
    public List<Car> getAll() throws SQLException {
        List<Car> car = new ArrayList<>();
        return car;
    }
}
