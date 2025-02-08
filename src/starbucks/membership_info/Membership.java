package starbucks.membership_info;

public class Membership {
    public int discount(MemberShipGrade memberShipGrade, int price) {
        int discountPercent = 0;

       //enum으로 변경하기
        if (memberShipGrade == MemberShipGrade.Basic) {
            discountPercent = 10;
        } else if (memberShipGrade == MemberShipGrade.GOLD) {
            discountPercent = 20;
        } else if (memberShipGrade == MemberShipGrade.VIP) {
            discountPercent = 30;
        } else {
            System.out.println("할인이 불가능합니다.");
            return 0;
        }
        return (price * discountPercent) / 100;
    }

    // 최종 결제 금액 계산하는 메서드
    public int calculateFinalPrice(MemberShipGrade memberShipGrade, int price) {
        int discountAmount = discount(memberShipGrade, price);
        return price - discountAmount;
    }
}
