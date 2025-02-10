package starbucks.membership;

public enum Grade {
    BASIC(10),GOLD(20),DIAMOND(30);

    private final int discountPercent;


    //생성자 생성해서 퍼센트율 넣어버리기
    Grade(int discountpercent) {
        this.discountPercent = discountpercent;

    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    //할인율계산하는 메서드 추가
    public int discount(int price) {
        System.out.printf("\n💳적용받는 할인율%d%n", getDiscountPercent());
        return price * discountPercent / 100;
    }

    //최종결제금액


}
