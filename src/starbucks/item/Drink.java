package starbucks.item;

import java.util.ArrayList;
import java.util.Arrays;

public enum Drink {
    아메리카노(4500, 8), 카페라떼(5000, 9), 카푸치노(5500 , 10), 자몽허니블랙티(6800, 80);

    private final int price;
    private final int waittime;

    Drink(int price, int waittime) {
        this.price = price;
        this.waittime = waittime;
    }

    public int getPrice() {
        return price;
    }
    public int getWaitTime() {
        return waittime * 1000;
    }
        public static ArrayList<Drink> getDrinks() {
        return new ArrayList<>(Arrays.asList(Drink.values()));
    }

}

