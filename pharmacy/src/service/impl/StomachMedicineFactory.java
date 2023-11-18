package service.impl;

import pojo.entity.Drug;
import pojo.entity.StomachMedicine;
import service.MedicineFactory;

public class StomachMedicineFactory extends MedicineFactory {
    @Override
    public Drug createMedicine() {
        System.out.println("Препараты от желудочной боли в корзине");
        return new StomachMedicine();
    }
}
