package by.epam.carrental.dao;

import by.epam.carrental.entity.Client;
import by.epam.carrental.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ClientDAO implements DAO<Client, Long> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Client entity) {
        String command = "INSERT INTO CLIENT(CLIENT_NAME" +
                                            ",CLIENT_SURNAME" +
                                            ",CLIENT_PHONE_NUMBER" +
                                            ",CLIENT_AGE" +
                                            ",CLIENT_CATEGORY" +
                                            ",CLIENT_DRIVING_EXPERIENCE" +
                                            ",CLIENT_GENDER" +
                                            ",CLIENT_ID) " +
                                            "Values (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(command, entity.getFirstName()
                                            ,entity.getLastName()
                                            ,entity.getPhoneNumber()
                                            ,entity.getAge()
                                            ,entity.getCategory()
                                            ,entity.getDrivingExperience()
                                            ,entity.getGender()
                                            ,entity.getId()
        ) > 0;
    }

    @Override
    public Client read(Long key) {
        String command = "SELECT * FROM CLIENT WHERE CLIENT_ID = ?";
        return jdbcTemplate.queryForObject(command, new Object[]{key}, new ClientMapper());
    }

    @Override
    public boolean update(Client entity) {
        String command = "UPDATE CLIENT SET CLIENT_NAME = ?" +
                                            ",CLIENT_SURNAME = ?" +
                                            ",CLIENT_PHONE_NUMBER = ? " +
                                            ",CLIENT_AGE = ?" +
                                            ",CLIENT_CATEGORY = ?" +
                                            ",CLIENT_DRIVING_EXPERIENCE = ?" +
                                            ",CLIENT_GENDER = ?" +
                        " WHERE CLIENT_ID = ?";
        return jdbcTemplate.update(command, entity.getFirstName()
                                            ,entity.getLastName()
                                            ,entity.getPhoneNumber()
                                            ,entity.getAge()
                                            ,entity.getCategory()
                                            ,entity.getDrivingExperience()
                                            ,entity.getGender()
                                            ,entity.getId()
        ) > 0;
    }

    @Override
    public boolean delete(Long key) {
        String command = "DELETE FROM CLIENT WHERE CLIENT_ID = ?";
        return jdbcTemplate.update(command, key) > 0;
    }

    @Override
    public List<Client> getAll() {
        String command = "SELECT * FROM CLIENT";
        return jdbcTemplate.query(command, new ClientMapper());
    }

}
