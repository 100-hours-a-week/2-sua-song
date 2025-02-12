package starbucks.order;

import starbucks.item.Dessert;
import starbucks.item.Drink;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderBook {
    private final BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private Drink selectedDrink;
    private Dessert selectedDessert;

    private static final List<Drink> drinkList = Drink.getDrinks();
    private static final List<Dessert> dessertList = Dessert.getDesserts();

    public BlockingQueue<Order> getOrderQueue() {
        return orderQueue;
    }

    public void drinkOrder(Scanner scanner) {
        System.out.println("📌 음료 메뉴:");
        for (int i = 0; i < drinkList.size(); i++) {
            System.out.println((i + 1) + ". " + drinkList.get(i).name() + " - " + drinkList.get(i).getPrice() + "원" + "   음료나오는데 소요시간 :" + drinkList.get(i).getWaitTime()/1000 + "초");
        }

        System.out.print("\n주문할 음료 번호를 선택하세요: ");
        int choice = scanner.nextInt();
        selectedDrink = drinkList.get(choice - 1);

        System.out.println("✅ 선택한 음료: " + selectedDrink.name());
    }

    public void dessertOrder(Scanner scanner) {
        System.out.println("📌 디저트 메뉴:");
        for (int i = 0; i < dessertList.size(); i++) {
            System.out.println((i + 1) + ". " + dessertList.get(i).name() + " - " + dessertList.get(i).getPrice() + "원");
        }

        System.out.print("\n번호를 선택하세요: ");
        int choice = scanner.nextInt();
        selectedDessert = dessertList.get(choice - 1);

        System.out.println("✅ 선택한 디저트: " + selectedDessert.name());
    }

    public Order createOrder() {
        if (selectedDrink == null || selectedDessert == null) {
            System.out.println("⚠️ 주문이 완성되지 않았습니다. 다시 시도하세요.");
            return null;
        }
        return new Order(selectedDrink, selectedDessert);
    }

    public int totalPrice() {
        if (selectedDrink == null || selectedDessert == null) {
            System.out.println("⚠️ [ERROR]: 음료 또는 디저트가 선택되지 않았습니다.");
            return 0;
        }

        int totalPrice = selectedDrink.getPrice() + selectedDessert.getPrice();
        System.out.println("\n💰 총 결제 금액: " + totalPrice + "원");
        return totalPrice;
    }

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
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        int change = payAmount - totalPrice;
        System.out.println("✅ 결제 완료! 잔돈: " + change + "원");
    }


    public void addOrderAsync() {
        Order order = createOrder();  //order생성해서 넣는 용도
        new Thread(() -> {
            try {
                orderQueue.put(order);
                System.out.println("\n 📦 주문 추가: " + order.getItemName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}