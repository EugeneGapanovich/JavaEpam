package by.epam.carrental.dao;

import by.epam.carrental.entity.Client;
import by.epam.carrental.exception.UserException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientDAO extends DAO<Client, String> {

    @Override
    public void create(Client entity) throws SQLException {
        try{
            String command = "INSERT INTO CLIENT Values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getPhoneNumber());
            preparedStatement.setInt(4, entity.getAge());
            preparedStatement.setString(5, entity.getCategory());
            preparedStatement.setString(6, entity.getDrivingExperience());
            preparedStatement.setString(7, entity.getGender());
            preparedStatement.setLong(8, entity.getId());

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("CREATED SUCCESSFULLY. ADDED ROWS: " + rows);
            } else{
                throw new SQLException("CLIENT IS NOT CREATED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public void read(String key) throws SQLException {
        try{
            Client client = new Client();
            String command = "SELECT * FROM CLIENT WHERE CLIENT_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                client = createClient(rs);
            }

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("READ SUCCESSFULLY. READ ROWS: " + rows);
            } else{
                throw new SQLException("CLIENT IS NOT READ");
            }

        } catch (SQLException e){
            log.info(e);
        }
    }

    @Override
    public void update(Client entity) throws SQLException {
        try{
            String command = "UPDATE CLIENT SET CLIENT_NAME = ?, CLIENT_SURNAME = ?, CLIENT_PHONE_NUMBER = ?," +
                    " CLIENT_AGE = ?, CLIENT_CATEGORY = ?, CLIENT_DRIVING_EXPERIENCE = ?, CLIENT_GENDER = ?" +
                    " WHERE CLIENT_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getPhoneNumber());
            preparedStatement.setInt(4, entity.getAge());
            preparedStatement.setString(5, entity.getCategory());
            preparedStatement.setString(6, entity.getDrivingExperience());
            preparedStatement.setString(7, entity.getGender());
            preparedStatement.setLong(8, entity.getId());

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("UPDATED SUCCESSFULLY. UPDATED ROWS: " + rows);
            } else{
                throw new SQLException("CLIENT IS NOT UPDATED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public void delete(String key) throws SQLException {
        try{
            String command = "DELETE FROM CLIENT WHERE CLIENT_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, key);

            Integer rows = preparedStatement.executeUpdate();
            if(rows > 0){
                log.info("DELETED SUCCESSFULLY. DELETED ROWS: " + rows);
            } else{
                throw new SQLException("CLIENT IS NOT DELETED");
            }
        } catch(SQLException e){
            log.info(e);
        }
    }

    @Override
    public List<Client> getAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        try {
            Client client = new Client();
            String command = "SELECT * FROM CLIENT";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            ResultSet rs = preparedStatement.executeQuery(command);
            while (rs.next()) {
                clients.add(createClient(rs));
            }
        } catch (SQLException e) {
            log.info(e);
        }
        return clients;
    }

    public Client createClient(ResultSet rs){
        Client client = new Client();
        try{
            client.setFirstName(rs.getString("CLIENT_NAME"));
            client.setLastName(rs.getString("CLIENT_SURNAME"));
            client.setPhoneNumber(rs.getString("CLIENT_PHONE_NUMBER"));
            client.setAge(rs.getInt("CLIENT_AGE"));
            client.setCategory(rs.getString("CLIENT_CATEGORY"));
            client.setDrivingExperience(rs.getString("CLIENT_DRIVING_EXPERIENCE"));
            client.setGender(rs.getString("CLIENT_GENDER"));
            client.setId(rs.getLong("CLIENT_ID"));
        } catch (SQLException e){
            log.info(e);
        } catch (UserException e){
            log.info(e);
        }
        return client;
    }
}
