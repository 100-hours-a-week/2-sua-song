package starbucks;

import starbucks.item_order.Desert;
import starbucks.item_order.Drink;
import starbucks.item_order.Item_Order;
import starbucks.membership_info.MemberShipGrade;
import starbucks.membership_info.Membership;
import starbucks.membership_info.Order;
//import starbucks.item_order.Order;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("🎉 스타벅스에 오신 것을 환영합니다! 🎉");
        System.out.println("==================================================");

        Item_Order.drink_order(in);

        System.out.println("\n==================================================\n");

        Item_Order.dessert_order(in);

//

        Item_Order.totalPrice();

        int totalPrice = Item_Order.totalPrice();
        //total 가격을 Order 전달하기
        Order order = new Order(totalPrice);
        //멤버십 넣기
        System.out.println("==================================================");
        order.apply_order(in);
        //order부분 메서드 가져오기
        order.printfinalprice();

    }






}

