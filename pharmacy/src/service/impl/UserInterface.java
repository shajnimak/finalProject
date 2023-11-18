package service.impl;

import pojo.entity.Drug;
import service.Interface;
import service.MedicineFactory;
import service.Price;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface implements Interface {
    @Override
    public void getInterface() {
        System.out.println("Рады вам снова видеть!!!");
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("-----------------------------");
            System.out.println("1. Список всех препаратов");
            System.out.println("2. Заказ");
            System.out.println("(Другое). Выйти из системы");
            System.out.println("-----------------------------");
            int caseNum = new Scanner(System.in).nextInt();
            switch (caseNum) {
                case 1:
                    Map<Integer, String> map = new HashMap<>();
                    map.put(1, "От головной боли");
                    map.put(2, "От кашели");
                    map.put(3, "От желудечной болт");
                    map.put(4, "От наружных ран");
                    for (int i = 1; i <= 4; i++) {
                        System.out.println(i + ". " + map.get(i));
                    }
                    break;
                case 2:
                    MedicineFactory factory = null;
                    System.out.println("Выберите препарат по номеру");
                    int number = new Scanner(System.in).nextInt();

                    Double cost;
                    switch (number) {
                        case 1:
                            factory = new HeadacheMedicineFactory();
                            break;
                        case 2:
                            factory = new CoughMedicineFactory();
                            break;
                        case 3:
                            factory = new StomachMedicineFactory();
                        case 4:
                            factory = new WoundMedicineFactory();
                            break;
                        default:
                            System.out.println("Такой продукции нет!");
                    }
                    if (factory == null) {
                        System.out.println("Вы не сделали заказ");
                        return;
                    }
                    Drug medicine = factory.createMedicine();
                    cost = medicine.produce();
                    Price price = new BasePrice(cost);
                    System.out.println("У вас есть бонусная карта или Вы пенсионер? д/н");
                    String str = new Scanner(System.in).nextLine();
                    if (str.equals("д")){
                        Price bonus = new BonusCard(price);
                        System.out.println("Цена: " + bonus.getPrice() + "$");
                    } else {
                        System.out.println("Цена: " + price.getPrice() + "$");
                    }
                    break;
                default:
                    return;
            }
        }
    }
}
