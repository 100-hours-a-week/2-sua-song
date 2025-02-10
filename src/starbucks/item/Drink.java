package starbucks.item;

import java.util.ArrayList;
import java.util.Arrays;

public enum Drink {
    아메리카노(4500), 카페라떼(5000), 카푸치노(5500), 자몽허니블랙티(6800);

    private final int price;

    Drink(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static ArrayList<Drink> getDrinks() {
        return new ArrayList<>(Arrays.asList(Drink.values()));
    }

}

