import pojo.entity.User;
import pojo.enums.Status;
import service.AuthService;
import service.Interface;
import service.impl.AdminInterface;
import service.impl.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean log = true;
        while (log) {
            boolean admin = false;
            System.out.println("Добро пожаловать в Онлайн Аптеку");
            System.out.println("Вам нужно авторизоваться!");
            System.out.print("Введите Login: ");
            String username = new Scanner(System.in).nextLine();
            System.out.print("Введите Password: ");
            String password = new Scanner(System.in).nextLine();
            AuthService authService = new AuthService();
            User user = authService.authorize(username, password);
            if (user != null) {
                if (user.getStatus().equals(Status.ADMIN)) {
                    admin = true;
                }
                System.out.println("Вы в системе");
            }
            Interface interFace;
            if (admin) {
                interFace = new AdminInterface();
                interFace.getInterface();
            } else {
                interFace = new UserInterface();
                interFace.getInterface();
            }
        }
    }
}
