package starbucks.membership;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30);

    private final int discountPercent;

    // 생성자 - 할인율 초기화
    Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    // 할인율을 반환하는 Getter 메서드
    public int getDiscountPercent() {
        return discountPercent;
    }

    // 멤버십 등급 리스트를 반환하는 정적 메서드
    public static List<Grade> getMembership() {
        return new ArrayList<>(Arrays.asList(Grade.values()));
    }

    // 할인된 가격 계산 메서드
    public int calculateDiscount(int price) {
        int discountAmount = price * discountPercent / 100;
        System.out.printf("\n💳 적용받는 할인율: %d%% (할인 금액: %d원)%n", getDiscountPercent(), discountAmount);
        return discountAmount;
    }

    // 최종 결제 금액 계산 메서드 (할인 적용)
    public int getFinalPrice(int price) {
        return price - calculateDiscount(price);
    }
}
