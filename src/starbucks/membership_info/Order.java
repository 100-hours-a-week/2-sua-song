package starbucks.membership_info;

import java.util.Scanner;

public class Order {
    private int total;
    private MemberShipGrade selectedMembership;
    private Membership membership;

    //생성자
    public Order(int totalPrice) {
        this.total = totalPrice;
        this.selectedMembership = null;
        this.membership = new Membership();
    }


    //멤버십 적용

    public void apply_order(Scanner scanner) {
        System.out.println("\n멤버십이 있습니까? (Y/N)  : ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("Y")) {
            System.out.println("📌 멤버십 등급을 선택하세요:");
            System.out.println("1. 실버 (10% 할인)");
            System.out.println("2. 골드 (20% 할인)");
            System.out.println("3. VIP (30% 할인)");

            int membershipChoice = scanner.nextInt();
            scanner.nextLine();

            if (membershipChoice == 1) {
                selectedMembership = MemberShipGrade.Basic;
                System.out.println("✅ 실버 멤버십이 적용되었습니다! (10% 할인)");

            } else if (membershipChoice == 2) {
                selectedMembership = MemberShipGrade.GOLD;
                System.out.println("✅ 골드 멤버십이 적용되었습니다! (20% 할인)");

            } else if (membershipChoice == 3) {
                selectedMembership = MemberShipGrade.VIP;
                System.out.println("✅ VIP 멤버십이 적용되었습니다! (30% 할인)");

            } else {
                System.out.println("⚠️ 올바른 번호를 입력해주세요. 멤버십 할인이 적용되지 않습니다.");
            }

        } else {
            System.out.println("\n❌ 멤버십이 없습니다. 정가로 결제됩니다.");
        }
    }
        // 📌 최종 결제 금액 계산
        public void printfinalprice() {
            int finalPrice = membership.calculateFinalPrice(selectedMembership, total);
            System.out.println("\n💳 최종 결제 금액: " + finalPrice + "원");
            System.out.println("\n✅ 주문이 완료되었습니다. 감사합니다!");
        };
}

