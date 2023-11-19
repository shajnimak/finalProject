package service.impl;

import service.Price;

public class BonusCard implements Price {
    private final Price price;

    public BonusCard(Price price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price.getPrice() - 60;
    }
}
