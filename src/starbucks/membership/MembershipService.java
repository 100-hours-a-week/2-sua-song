package starbucks.membership;

public class MembershipService {


        // 멤버십 적용 메서드
        public void applyOrder(Scanner scanner) {
            System.out.print("\n멤버십이 있습니까? (Y/N): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("Y")) {
                System.out.println("📌 멤버십 등급을 선택하세요:");
                System.out.println("1. Basic (10% 할인)");
                System.out.println("2. GOLD (20% 할인)");
                System.out.println("3. VIP (30% 할인)");

                int choice = scanner.nextInt();
                scanner.nextLine(); // 개행문자 처리

                switch (choice) {
                    case 1:
                        selectedMembership = starbucks.membership_info.MemberShipGrade.Basic;
                        System.out.println("✅ Basic 멤버십이 적용되었습니다! (10% 할인)");
                        break;
                    case 2:
                        selectedMembership = starbucks.membership_info.MemberShipGrade.GOLD;
                        System.out.println("✅ GOLD 멤버십이 적용되었습니다! (20% 할인)");
                        break;
                    case 3:
                        selectedMembership = starbucks.membership_info.MemberShipGrade.VIP;
                        System.out.println("✅ VIP 멤버십이 적용되었습니다! (30% 할인)");
                        break;
                    default:
                        System.out.println("⚠️ 올바른 번호를 입력해주세요. 멤버십 할인이 적용되지 않습니다.");
                        selectedMembership = MemberShipGrade.Basic; // 기본 등급 적용
                }
            } else {
                System.out.println("\n❌ 멤버십이 없습니다. 정가로 결제됩니다.");
            }
        }

        // 최종 결제 금액 반환 메서드
        public int getFinalPrice() {
            int finalPrice =
                    System.out.println("\n💳 최종 결제 금액: " + finalPrice + "원");
            return finalPrice;
        }
    }
}
