package starbucks.membership;

public enum Grade {
    BASIC,GOLD,DIAMOND;

    private int discountPercent;


    Grade(int discountpercent) {
        this.discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }



}
