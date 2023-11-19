package service;

import dbConnection.DBConnection;
import pojo.entity.User;
import util.impl.CryptoConverter;

public class AuthService {
    public static final String USER_TABLE_NAME = "user";
    private final DBConnection dbConnection = DBConnection.getDbConnection();
    public void register(User user) {
        CryptoConverter cryptoConverter = new CryptoConverter(user);
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setStatus(user.getStatus());
        newUser.setPassword(cryptoConverter.encrypt());
        dbConnection.insertUser(newUser);
    }
    public User authorize(String inputUsername, String inputPassword) {
        User user = dbConnection.selectUser(inputUsername);
        CryptoConverter cryptoConverter = new CryptoConverter(user);
        if (cryptoConverter.decrypt().equals(inputPassword)) {
            return user;
        } else {
            throw new RuntimeException("Неверный логин или пароль!");
        }
    }
}
