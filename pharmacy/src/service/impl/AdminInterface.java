package service.impl;

import pojo.entity.User;
import pojo.enums.Status;
import service.AuthService;
import service.Interface;
import service.ObserveService;
import service.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminInterface implements Interface {
    @Override
    public void getInterface() {
        System.out.println("ВЫ АДМИН В СИСТЕМЕ");
        System.out.println("ВАМ ДОСТУПНО:");
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("-----------------------------");
            System.out.println("1. Получить поставку в Аптеку");
            System.out.println("2. Добить нового пользователя");
            System.out.println("(Другое). Выйти из системы");
            System.out.println("-----------------------------");
            int caseNum = new Scanner(System.in).nextInt();
            switch (caseNum) {
                case 1:
                    ObserveService observeService = new ObserveService();
                    List<String> products = new ArrayList<>();
                    System.out.println("Сколько препаратов Поступило?");
                    int number = new Scanner(System.in).nextInt();
                    for (int i =0; i < number; i++){
                        System.out.print("Название: ");
                        String product = new Scanner(System.in).nextLine();
                        products.add(product);
                    }
                    observeService.addMaterials(products);
                    break;
                case 2:
                    System.out.print("Введите айди: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.print("Введите логин: ");
                    String username = new Scanner(System.in).nextLine();
                    System.out.print("Введите пароль: ");
                    String password = new Scanner(System.in).nextLine();
                    User user = new User(id, username, Status.USER, password);
                    AuthService authService = new AuthService();
                    authService.register(user);
                    System.out.println("Рады видеть нового пользователя!");
                    break;
                default:
                    return;
            }
        }
    }
}
