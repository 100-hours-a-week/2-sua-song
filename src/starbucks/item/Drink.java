package starbucks.item;

import java.util.ArrayList;
import java.util.Arrays;

public enum Drink {
    아메리카노(4500, 3000), 카페라떼(5000, 4000), 카푸치노(5500 , 6000), 자몽허니블랙티(6800, 8000);

    private final int price;
    private final int waittime;

    Drink(int price, int waittime) {
        this.price = price;
        this.waittime = waittime;
    }

    public int getPrice() {
        return price;
    }

    public static ArrayList<Drink> getDrinks() {
        return new ArrayList<>(Arrays.asList(Drink.values()));
    }

}

