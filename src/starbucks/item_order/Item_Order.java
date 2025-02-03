package starbucks.item_order;
import java.util.Scanner;

public class Item_Order {
    private Drink drink;
    private Desert desert;
    private static Drink selectedDrink;
    private static Desert selectedDesert;


    //생성자

    public Item_Order(Drink drink, Desert desert) {
        this.drink = drink;
        this.desert = desert;
    }

    //drink메서드
    public static void drink_order(Scanner in) {
        System.out.println("==================================================");
        System.out.println("메뉴를 골라주세요");
        System.out.println("==================================================");
        System.out.println("📌 음료 메뉴:");
        Drink[] drinkarray = Drink.getDrinkMenu();
        for (int i = 0; i < drinkarray.length; i++) {
            System.out.println((i + 1) + "." + drinkarray[i].getName() + " " + drinkarray[i].getPrice());
        }

        System.out.println("\n 음료를 선택하세요(번호 입력) : ");
        int choice = in.nextInt();
        selectedDrink = drinkarray[choice - 1];
        System.out.print("\n선택한 음료 : " + selectedDrink.getName());

    }


    public static void dessert_order(Scanner in) {
        System.out.println("📌 디저트 메뉴 :");
        Desert[] desertsarray = Desert.DessrtMenu();
        for (int i = 0; i < desertsarray.length; i++) {
            System.out.println((i + 1) + "." + desertsarray[i].getName() + " " + desertsarray[i].getPrice());
        }

        System.out.println("\n 디저트를 선택하세요 (번호 입력) : ");
        int desertChoice = in.nextInt();
        selectedDesert = desertsarray[desertChoice - 1];

        System.out.println("\n 선택한 디저트 : " + selectedDesert.getName());
        System.out.println("\n==================================================\n");
    }

    //총 가격 메서드
    public static int totalPrice() {
        if(selectedDesert == null || selectedDrink == null) {
            System.out.println("음료 또는 디저트가 선택되지 않았습니다.");
            return 0;
        }
        int totalPrice = selectedDesert.getPrice() + selectedDrink.getPrice();
        System.out.println("결제해야하는 총 금액 : " + totalPrice + "원");
        return totalPrice;
    }
}
