package starbucks.membership_info;

public class MemberShipGrade {
    public static final MemberShipGrade Basic = new MemberShipGrade();
    public static final MemberShipGrade GOLD = new MemberShipGrade();
    public static final MemberShipGrade VIP = new MemberShipGrade();


    //생성자 막아버리기
    private MemberShipGrade() {}
}
