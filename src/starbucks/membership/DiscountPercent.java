package starbucks.membership;
//할인금액만 유지
public class DiscountPercent {
    public int getDiscountPrice(int price, Grade grade) {
        int discountAmount = (price * grade.getDiscountPercent()) / 100; // 할인 금액 계산
        return price - discountAmount; // 최종 가격 반환
    }
}
