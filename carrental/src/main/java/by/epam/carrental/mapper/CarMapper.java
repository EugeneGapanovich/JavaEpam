package by.epam.carrental.mapper;

import by.epam.carrental.entity.Car;
import by.epam.carrental.exception.CarException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    static Logger log = LogManager.getLogger();

    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        try{
            car.setName(resultSet.getString("CAR_NAME"));
            car.setModel(resultSet.getString("CAR_MODEL"));
            car.setYearOfCar(resultSet.getInt("CAR_YEAR"));
            car.setPrice(resultSet.getBigDecimal("CAR_PRICE"));
            car.setId(resultSet.getLong("CAR_ID"));
        } catch (CarException e){
            log.info(e);
        }
        return car;
    }
}
