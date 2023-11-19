package service.impl;

import service.Price;

public class BasePrice implements Price {
    private final Double price;

    public BasePrice(Double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
