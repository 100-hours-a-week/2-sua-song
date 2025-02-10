package starbucks.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembershipService {
    private Grade selectedMembership = null; // 기본값 제거
    private final DiscountPercent discountCalculator;

    // 멤버십 목록을 ArrayList로 해서 나중에 추가하는 것이 쉬울 수 있게 설정
    private static final List<Grade> membershipList = new ArrayList<>();

    static {
        membershipList.add(Grade.BASIC);
        membershipList.add(Grade.GOLD);
        membershipList.add(Grade.DIAMOND);
    }

    // 생성자를 통해 DiscountPercent 주입
    public MembershipService(DiscountPercent discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    // 멤버십 적용 메서드
    public void applyOrder(Scanner scanner) {
        System.out.print("\n멤버십이 있습니까? (Y/N): ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("Y")) {
            System.out.println("📌 멤버십 등급을 선택하세요:");

            // ArrayList를 사용해서 두번 일 안하게 만듬, 인덱스 0번부터니 +1 하여 설정
            for (int i = 0; i < membershipList.size(); i++) {
                System.out.println((i + 1) + ". " + membershipList.get(i).name() + " (" + membershipList.get(i).getDiscountPercent() + "% 할인)");
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            if (choice >= 1 && choice <= membershipList.size()) {
                selectedMembership = membershipList.get(choice - 1);
                System.out.println("✅ " + selectedMembership.name() + " 멤버십이 적용되었습니다! (" + selectedMembership.getDiscountPercent() + "% 할인)");
            } else {
                System.out.println("⚠️ 올바른 번호를 입력해주세요. 멤버십이 적용되지 않습니다.");
                selectedMembership = null;
            }
        } else {
            System.out.println("\n❌ 멤버십이 없습니다. 정가로 결제됩니다.");
            selectedMembership = null;
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
