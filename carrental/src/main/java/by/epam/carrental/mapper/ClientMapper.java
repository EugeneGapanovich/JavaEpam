package by.epam.carrental.mapper;

import by.epam.carrental.entity.Client;
import by.epam.carrental.exception.UserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {

    static Logger log = LogManager.getLogger();

    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();
        try{
            client.setFirstName(resultSet.getString("CLIENT_NAME"));
            client.setLastName(resultSet.getString("CLIENT_SURNAME"));
            client.setPhoneNumber(resultSet.getString("CLIENT_PHONE_NUMBER"));
            client.setAge(resultSet.getInt("CLIENT_AGE"));
            client.setCategory(resultSet.getString("CLIENT_CATEGORY"));
            client.setDrivingExperience(resultSet.getString("CLIENT_DRIVING_EXPERIENCE"));
            client.setGender(resultSet.getString("CLIENT_GENDER"));
            client.setId(resultSet.getLong("CLIENT_ID"));
        } catch (UserException e){
            log.info(e);
        }
        return client;
    }
}
