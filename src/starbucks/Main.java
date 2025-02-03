package starbucks;

import starbucks.item_order.Desert;
import starbucks.item_order.Drink;
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
        System.out.println("메뉴를 골라주세요");
        System.out.println("==================================================");
        System.out.println("📌 음료 메뉴:");
        //음료, 디저트 가져오기
        Drink[] drinksarray = Drink.getDrinkMenu();
        for (int i = 0; i < drinksarray.length; i++) {
            System.out.println((i + 1) + "." + drinksarray[i].getName() + " " + drinksarray[i].getPrice());
        }
        System.out.print("\n음료를 선택하세요 (번호 입력): ");
        int drinkChoice = in.nextInt();
        //인덱스 1 제거해서 고른 메뉴 가져오기
        Drink selectedDrink = drinksarray[drinkChoice - 1];
        System.out.print("\n선택한 음료 : " + selectedDrink.getName());


        System.out.println("\n==================================================\n");
        System.out.println("📌 디저트 메뉴 :");

        Desert[] desertsarray = Desert.DessrtMenu();
        for (int i = 0; i < desertsarray.length; i++) {
            System.out.println((i + 1) + "." + desertsarray[i].getName() + " " + desertsarray[i].getPrice());
        }

        System.out.println("\n 디저트를 선택하세요 (번호 입력) : ");
        int desertChoice = in.nextInt();
        Desert selectedDesert = desertsarray[desertChoice - 1];
        System.out.println("\n 선택한 디저트 : " + selectedDesert.getName());
        System.out.println("\n==================================================\n");
        
        
        //음식 가격
        int totalPrice = selectedDesert.getPrice() + selectedDrink.getPrice();

        //total 가격을 Order 전달하기
        Order order = new Order(totalPrice);
        //멤버십 넣기
        order.apply_order(in);
        //order부분 메서드 가져오기
        order.printfinalprice();

    }






}

