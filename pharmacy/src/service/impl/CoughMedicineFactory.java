package service.impl;

import pojo.entity.CoughMedicine;
import pojo.entity.Drug;
import service.MedicineFactory;

class CoughMedicineFactory extends MedicineFactory {
    @Override
    public Drug createMedicine() {
        System.out.println("Препараты от кашели в корзине");
        return new CoughMedicine();
    }
}
