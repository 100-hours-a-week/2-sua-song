package starbucks.client;

import starbucks.order.Order;
import starbucks.order.OrderBook;

public class Customer implements Runnable {
    private final OrderBook orderBook;

    public Customer(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void run() {
        Order order = orderBook.createOrder(); // 선택된 음료 & 디저트로 주문 생성
        if (order != null) {
            System.out.println("👨‍💼 손님: " + order.getItemName() + " 하나 주세요!");
            orderBook.addOrderAsync(order); // 주문 큐에 추가
        }
    }
}
