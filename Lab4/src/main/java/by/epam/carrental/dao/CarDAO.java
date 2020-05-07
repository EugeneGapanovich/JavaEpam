package by.epam.carrental.dao;

import by.epam.carrental.entity.Car;
import by.epam.carrental.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CarDAO implements DAO<Car, Long> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Car entity){
        String command = "INSERT INTO CAR(CAR_NAME" +
                                        ",CAR_MODEL" +
                                        ",CAR_YEAR" +
                                        ",CAR_PRICE" +
                                        ",CAR_ID) " +
                                        "Values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(command, entity.getName()
                                            ,entity.getModel()
                                            ,entity.getYearOfCar()
                                            ,entity.getPrice()
                                            ,entity.getId()
        ) > 0;
    }

    @Override
    public Car read(Long key) {
            Car car = new Car();
            String command = "SELECT * FROM CAR WHERE CAR_ID = ?";
            return jdbcTemplate.queryForObject(command, new Object[]{key}, new CarMapper());
    }

    @Override
    public boolean update(Car entity) {
        String command = "UPDATE CAR SET CAR_NAME = ?, CAR_MODEL = ?, CAR_YEAR = ?, CAR_PRICE = ? WHERE CAR_ID = ?";
        return jdbcTemplate.update(command, entity.getName()
                                            ,entity.getModel()
                                            ,entity.getYearOfCar()
                                            ,entity.getPrice()
                                            ,entity.getId()
        ) > 0;
    }

    @Override
    public boolean delete(Long key) {
        String command = "DELETE FROM CAR WHERE CAR_ID = ?";
        return jdbcTemplate.update(command, key) > 0;
    }

    @Override
    public List<Car> getAll(){
        String command = "SELECT * FROM CAR";
        return jdbcTemplate.query(command, new CarMapper());
    }

}
