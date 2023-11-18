package service.impl;

import pojo.entity.Drug;
import pojo.entity.HeadacheMedicine;
import service.MedicineFactory;

public class HeadacheMedicineFactory extends MedicineFactory {
    @Override
    public Drug createMedicine() {
        System.out.println("Препараты от головной боли в корзине");
        return new HeadacheMedicine();
    }
}
