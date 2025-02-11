package starbucks.role;


import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Barista implements Runnable{
    //큐로 주문받기
    private BlockingQueue<String> orderqueue;

    public Barista(BlockingQueue<String> orderqueue, String order) {
        this.orderqueue = orderqueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String order = orderqueue.poll();
                System.out.println(order + "제조 시작");
                Thread.sleep(1000);//커피 제조 시간
                if (Math.random() > 0.6) {
                    System.out.println(order + "커피 제조 완료 !");
                } else {
                    System.out.println(order + "커피 제조 실패했습니다!");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
