package starbucks.membership;

public class DiscountPercent {
    public int discount(Grade grade, int price) {
        return grade.getDiscountPercent() * price / 100;
    }

}
