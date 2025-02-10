package starbucks.membership;

import java.util.Scanner;

public class MembershipService {
    private Grade selectedMembership = null; //맴버십 등급 조정
    private final DiscountPercent discountCalculator;

    // 생성자를 통해 DiscountPercent 주입
    public MembershipService(DiscountPercent discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    // 멤버십 적용 메서드
    public void applyOrder(Scanner scanner) {
        System.out.print("\n멤버십이 있습니까? (Y/N): ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("Y")) {
            //이부분 list에 넣어서 인덱스로 받아오게 해보자.
            System.out.println("📌 멤버십 등급을 선택하세요:");
            System.out.println("1. BASIC (10% 할인)");
            System.out.println("2. GOLD (20% 할인)");
            System.out.println("3. DIAMOND (30% 할인)");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                    selectedMembership = Grade.BASIC;
                    System.out.println("✅ BASIC 멤버십이 적용되었습니다! (10% 할인)");
                    break;
                case 2:
                    selectedMembership = Grade.GOLD;
                    System.out.println("✅ GOLD 멤버십이 적용되었습니다! (20% 할인)");
                    break;
                case 3:
                    selectedMembership = Grade.DIAMOND;
                    System.out.println("✅ DIAMOND 멤버십이 적용되었습니다! (30% 할인)");
                    break;
                default:
                    System.out.println("⚠️ 올바른 번호를 입력해주세요. 멤버십이 적용되지 않습니다.");
                    selectedMembership = null;
            }
        } else {
            System.out.println("\n❌ 멤버십이 없습니다. 정가로 결제됩니다.");
            selectedMembership = null; // 멤버십이 없으면 null 유지
        }
    }

    // 최종 결제 금액 반환 메서드
    public int getFinalPrice(int originalPrice) {
        if (selectedMembership == null) {
            System.out.println("\n💳 멤버십 없음: 정가 " + originalPrice + "원 결제됩니다.");
            return originalPrice;
        }

        int finalPrice = discountCalculator.getDiscountPrice(originalPrice, selectedMembership);
        System.out.println("\n💳 최종 결제 금액: " + finalPrice + "원");
        return finalPrice;
    }
}
