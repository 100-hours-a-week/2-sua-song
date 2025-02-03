package starbucks;

import starbucks.item_order.Item_Order;
import starbucks.membership_info.Order;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("🎉 스타벅스에 오신 것을 환영합니다! 🎉");
        System.out.println("==================================================");

        // 음료 및 디저트 주문
        Item_Order.drink_order(in);
        System.out.println("\n==================================================\n");
        Item_Order.dessert_order(in);

        // 총 가격 계산
        int totalPrice = Item_Order.totalPrice();

        // 멤버십 등급 선택 및 적용
        System.out.println("==================================================");
        Order order = new Order(totalPrice); // Order 객체 생성
        order.applyOrder(in); // 멤버십 적용

        // 할인된 최종 결제 금액 확인
        int finalPrice = order.getFinalPrice();

        // 결제 진행
        Item_Order.paymoney(in, finalPrice);

        in.close(); // Scanner 닫기
    }
}