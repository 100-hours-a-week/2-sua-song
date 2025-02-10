package starbucks.item;

public enum Dessert {
    치즈케이크(5000), 초코쿠키(3000), 마카롱(2500); // 모든 항목에 가격 지정

    private final int price;

    Dessert(int price) { // 생성자
        this.price = price;
    }

    public int getPrice() { // 가격을 가져오는 getter 메서드
        return price;
    }
}
