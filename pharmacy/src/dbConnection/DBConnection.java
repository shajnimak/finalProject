package dbConnection;

import pojo.entity.User;
import pojo.enums.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection dbConnection;
    private static final String url = "jdbc:postgresql://localhost:5432/pharmacy";
    private static final String username = "postgres";
    private static final String password = "shadyman";
    private Connection connection;

    private DBConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getDbConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Long getLastId() {
        String script = "SELECT id FROM users ORDER BY id DESC LIMIT 1;";
        long id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(script);
            ResultSet resultSet = preparedStatement.executeQuery();
            id = resultSet.getLong("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
    public void insertUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (id, username, status, password) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, Math.toIntExact(user.getId()));
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getStatus().toString());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User selectUser(String inputUsername) {
//
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from users where username = ? limit 1");
            preparedStatement.setString(1, inputUsername);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Status status = Status.valueOf(resultSet.getString("status"));
                return new User(id, username, status, password);
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return null;
    }
    public List<String> selectAllUsers() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> usernames = new ArrayList<>();

            while (resultSet.next()) {
                String value = resultSet.getString("username");
                usernames.add(value);
            }
            return usernames;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
