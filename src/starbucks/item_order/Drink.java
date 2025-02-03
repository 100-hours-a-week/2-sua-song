package starbucks.item_order;

import java.util.ArrayList;
import java.util.List;

public class Drink extends MenuItem{
    public Drink(String name, int price) {
        super(name, price);
    }

    //디저트들은 리스트에 저장(변경불가능하도록 파이널 사용)
    public static final Drink[] getDrinkMenu() {
        return new Drink[] {
                new Drink("아메리카노", 4500),
                new Drink("카페라떼", 5000),
                new Drink("카푸치노", 5500),
                new Drink("자몽허니블랙티", 6800)
        };
    }

}
