package starbucks.order;

import starbucks.exception.InputValidator;
import starbucks.item.Dessert;
import starbucks.item.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class OrderBook {
    //주문하는 큐 추가
    private final BlockingDeque<String> orderQueue = new LinkedBlockingDeque<>();

    private Drink selectedDrink;  // 선택된 음료
    private Dessert selectedDessert;  // 선택된 디저트
    private static final List<Drink> drinkList = Drink.getDrinks();  // 음료 리스트
    private static final List<Dessert> dessertList = Dessert.getDesserts(); // 디저트 리스트

    // 음료 주문 메서드
    public void drinkOrder(Scanner scanner) {
        System.out.println("==================================================");
        System.out.println("📌 음료 메뉴:");

        for (int i = 0; i < drinkList.size(); i++) {
            System.out.println((i + 1) + ". " + drinkList.get(i).name() + " - " + drinkList.get(i).getPrice() + "원");
        }

        System.out.print("\n번호를 선택하세요: ");
        int choice = InputValidator.validateMenuChoice(scanner, drinkList.size());
        selectedDrink = drinkList.get(choice - 1);

        System.out.println("✅ 선택한 음료: " + selectedDrink.name());
    }

    // 디저트 주문 메서드
    public void dessertOrder(Scanner scanner) {
        System.out.println("==================================================");
        System.out.println("📌 디저트 메뉴:");

        for (int i = 0; i < dessertList.size(); i++) {
            System.out.println((i + 1) + ". " + dessertList.get(i).name() + " - " + dessertList.get(i).getPrice() + "원");
        }

        System.out.print("\n번호를 선택하세요: ");
        int choice = InputValidator.validateMenuChoice(scanner, dessertList.size());
        selectedDessert = dessertList.get(choice - 1);

        System.out.println("✅ 선택한 디저트: " + selectedDessert.name());
        return new ordermenu(selectedDessert);
    }

    // 총 가격 계산
    public int totalPrice() {
        if (selectedDrink == null || selectedDessert == null) {
            System.out.println("⚠️ [ERROR]: 음료 또는 디저트가 선택되지 않았습니다.");
            return 0;
        }

        int totalPrice = selectedDrink.getPrice() + selectedDessert.getPrice();
        System.out.println("\n💰 총 결제 금액: " + totalPrice + "원");
        return totalPrice;
    }

    // 결제 및 잔돈 계산
    public void payMoney(Scanner scanner, int totalPrice) {
        int payAmount = 0;

        while (true) {
            try {
                System.out.print("\n💵 지불할 금액을 입력하세요: ");

                if (!scanner.hasNextInt()) {
                    throw new IllegalArgumentException("⚠️ [ERROR]: 숫자만 입력해주세요.");
                }

                payAmount = scanner.nextInt();
                scanner.nextLine();

                if (payAmount < totalPrice) {
                    throw new IllegalArgumentException("⚠️ [ERROR]: 지불 금액이 부족합니다. 더 넣어주세요.");
                }
                break; // 정상 입력 시 반복 종료

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // 입력 버퍼 초기화
            }
        }

        int change = payAmount - totalPrice;
        System.out.println("✅ 결제 완료! 잔돈: " + change + "원");
    }

    public void ordermenu(selectedDrink) {

    }
}

