package starbucks.role;
import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
    private String Order order;
    private BlockingQueue<String> orderqueue;

    public Customer(String order, BlockingQueue<String> orderqueue) {
        this.order = order;
        this.orderqueue = orderqueue;
    }

    @Override
    public void run() {
    try {
        System.out.println("손님" + order + "주세요");
        orderqueue.put(order);  //큐안에 주문 넣기
        System.out.println("손님 : 주문완료");
    }  catch (InterruptedException e) {
        System.out.println("customer 작업이 중단되었습니다");
        e.printStackTrace();
    }

    }
}
