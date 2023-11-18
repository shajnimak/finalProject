package service;

import dbConnection.DBConnection;
import service.impl.ConcreteObserver;

import java.util.List;

public class ObserveService {
    private final DBConnection dbConnection = DBConnection.getDbConnection();


    public void addMaterials(List<String> material) {
        observeAll(material);
    }

    public void observeAll(List<String> drugs) {
        Subject subject = new Subject();
        List<String> usernames = dbConnection.selectAllUsers();

        for (String username : usernames) {
            subject.addObserver(new ConcreteObserver(username));
        }

        for (String drug : drugs) {
            subject.newArrival(drug);
        }
    }
}
