package starbucks;

import starbucks.order.OrderBook;
import starbucks.order.Order;
import starbucks.client.Customer;
import starbucks.barista.Barista;
import starbucks.membership.MembershipService;
import starbucks.membership.DiscountPercent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderBook orderBook = new OrderBook();
        DiscountPercent discountPercent = new DiscountPercent();
        MembershipService membershipService = new MembershipService(discountPercent);

        System.out.println("\n🌟 스타벅스 키오스크에 오신 것을 환영합니다! 🌟");

        while (true) {
            orderBook.drinkOrder(scanner);
            orderBook.dessertOrder(scanner);

            // 멤버십 할인 적용
            membershipService.applyOrder(scanner);
            int totalPrice = orderBook.totalPrice();
            int finalPrice = membershipService.getFinalPrice(totalPrice);
            orderBook.payMoney(scanner, finalPrice);

            orderBook.addOrderToQueue(); // 주문을 큐에 추가

            System.out.print("🚀 추가 주문하시겠습니까? (Y/N): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }

        // 바리스타 스레드 시작
        Barista barista = new Barista(orderBook);
        new Thread(barista).start();

        System.out.println("✅ 주문이 완료되었습니다! 바리스타가 음료를 제조 중입니다...");
        scanner.close();
    }
}
