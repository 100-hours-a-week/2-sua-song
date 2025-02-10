package starbucks.item;

public enum Drink {
    아메리카노(4500), 카페라떼(5000), 카푸치노(5500), 자몽허니블랙티(6800);

    private final int price;

    Drink(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}

