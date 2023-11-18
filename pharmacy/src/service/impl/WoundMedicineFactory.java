package service.impl;

import pojo.entity.Drug;
import pojo.entity.WoundMedicine;
import service.MedicineFactory;

public class WoundMedicineFactory extends MedicineFactory {
    @Override
    public Drug createMedicine() {
        System.out.println("Препараты от наружных ран в корзине");
        return new WoundMedicine();
    }
}
