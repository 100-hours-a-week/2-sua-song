package starbucks.role;

import starbucks.order.OrderBook;

public class Customer implements Runnable {
    private final OrderBook orderBook;

    public Customer(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void run() {
        orderBook.addOrderAsync();
    }
}
