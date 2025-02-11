package starbucks.order;
import starbucks.item.Drink;
import starbucks.item.Dessert;

public class Order {
    private final Drink drink;
    private final Dessert dessert;

    public Order(Drink drink, Dessert dessert) {
        this.drink = drink;
        this.dessert = dessert;
    }

    public String getItemName() {
        return drink.name() + " & " + dessert.name();
    }

    public int getWaitTime() {
        return drink.getWaitTime(); // 음료의 제조 시간 사용
    }
}