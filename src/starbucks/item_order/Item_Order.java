package starbucks.item_order;
import starbucks.exception.InputValidator;
import starbucks.membership_info.Order;
import java.util.Scanner;

public class Item_Order {
    private Drink drink;
    private Desert desert;
    private static Drink selectedDrink;
    private static Desert selectedDesert;


    //생성자
    public Item_Order(Drink drink, Desert desert) {
        this.drink = drink;
        this.desert = desert;
    }

    //drink메서드
    public static void drink_order(Scanner in) {
        System.out.println("==================================================");
        System.out.println("메뉴를 골라주세요");
        System.out.println("==================================================");
        System.out.println("📌 음료 메뉴:");
        Drink[] drinkarray = Drink.getDrinkMenu();
        for (int i = 0; i < drinkarray.length; i++) {
            System.out.println((i + 1) + "." + drinkarray[i].getName() + " " + drinkarray[i].getPrice());
        }
        int choice = InputValidator.validateMenuChoice(in, drinkarray.length);
        selectedDrink = drinkarray[choice - 1];
        System.out.print("\n선택한 음료 : " + selectedDrink.getName());

    }


    public static void dessert_order(Scanner in) {
        System.out.println("📌 디저트 메뉴 :");
        Desert[] desertsarray = Desert.DessrtMenu();
        for (int i = 0; i < desertsarray.length; i++) {
            System.out.println((i + 1) + "." + desertsarray[i].getName() + " " + desertsarray[i].getPrice());
        }

        int desertChoice = InputValidator.validateMenuChoice(in, desertsarray.length);
        selectedDesert = desertsarray[desertChoice - 1];

        System.out.println("\n 선택한 디저트 : " + selectedDesert.getName());
        System.out.println("\n==================================================\n");
    }

    //총 가격 메서드
    public static int totalPrice() {
        if (selectedDesert == null || selectedDrink == null) {
            System.out.println("음료 또는 디저트가 선택되지 않았습니다.");
            return 0;
        }
        int totalPrice = selectedDesert.getPrice() + selectedDrink.getPrice();
        System.out.println("결제해야하는 총 금액 : " + totalPrice + "원");
        return totalPrice;
    }

    /// 지불할 금액 입력 및 잔돈 계산
    public static void paymoney(Scanner in, int totalPrice2) {
        int paymoney = 0;

        while (true) {
            try {
                System.out.print("💰 지불할 금액을 입력하세요: ");

                // 숫자가 아닌 입력을 방지하기 위해 입력을 문자열로 받고 숫자로 변환
                if (!in.hasNextInt()) {
                    throw new IllegalArgumentException("⚠️ [ERROR]: 숫자만 입력해주세요.");
                }

                paymoney = in.nextInt();

                if (paymoney < totalPrice2) {
                    throw new IllegalArgumentException("⚠️ [ERROR]: 지불하신 금액이 부족합니다. 돈을 더 넣어주세요.");
                }
                break; // 정상 입력이면 while문 종료

            } catch (IllegalArgumentException e) { // 숫자 입력 오류 & 금액 부족 예외 처리
                System.out.println(e.getMessage());
                in.nextLine(); // 입력 버퍼 초기화
            }
        }

        int change = paymoney - totalPrice2;
        System.out.println("✅ 결제 완료! 잔돈: " + change + "원");
    }
}
