package starbucks;

import starbucks.order.OrderBook;
import starbucks.membership.MembershipService;
import starbucks.membership.DiscountPercent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiscountPercent discountCalculator = new DiscountPercent(); // 할인 계산기 객체 생성
        MembershipService membershipService = new MembershipService(discountCalculator);
        OrderBook orderBook = new OrderBook(); // 주문 관리 객체 생성

        System.out.println("\n🌟 스타벅스 키오스크에 오신 것을 환영합니다! 🌟");

        // 멤버십 선택
        membershipService.applyOrder(scanner);

        // 음료 & 디저트 주문
        orderBook.drinkOrder(scanner);
        orderBook.dessertOrder(scanner);

        // 최종 결제 금액 계산 (멤버십 할인 적용)
        int totalPrice = orderBook.totalPrice();
        int discountedPrice = membershipService.getFinalPrice(totalPrice);

        // 결제 수행
        if (discountedPrice > 0) {
            orderBook.payMoney(scanner, discountedPrice);
        }

        //비동기적으로 실행하는 부분
        System.out.println("손님들이 주문을 했습니다.");
        일
        System.out.println("\n☕ 감사합니다! 좋은 하루 보내세요! ☕");
        scanner.close();
    }
}
