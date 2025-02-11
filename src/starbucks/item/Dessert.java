package starbucks.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Dessert {
    치즈케이크(5000), 초코쿠키(3000), 마카롱(2500); // 모든 항목에 가격 지정

    private final int price;

    Dessert(int price) { // 생성자
        this.price = price;
    }

    public int getPrice() { // 가격을 가져오는 getter 메서드
        return price;
    }

    //list를 이용해서 작성한 아이템들을 자동으로 메서드에 넣어버리기
    public static List<Dessert> getDesserts() {
        return new ArrayList<Dessert>(Arrays.asList(values()));
    }

}
