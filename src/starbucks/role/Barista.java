package starbucks.barista;

import starbucks.order.Order;
import starbucks.order.OrderBook;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Barista implements Runnable {
    private final OrderBook orderBook;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Barista(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Order order = orderBook.getOrderQueue().take(); // 주문 가져오기
                System.out.println("👨‍🍳 바리스타: " + order.getItemName() + " 제조 시작!");

                scheduler.schedule(() -> {
                    System.out.println("☕ 바리스타: " + order.getItemName() + " 제조 완료!");
                }, order.getWaitTime(), TimeUnit.MILLISECONDS);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
