package starbucks.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    public static int validateMenuChoice(Scanner scanner, int maxMenuNumber) {
        while (true) {
            try {
            System.out.println("\n 원하는 상품의 번호를 입력하시오 : ");
            int choice = scanner.nextInt();

            if (choice > maxMenuNumber || choice < 1) {
                throw new IllegalArgumentException("[ERROR] 올바른 메뉴 번호를 입력하세요. 다시 입력해주세요.");
            } return choice;

            } catch (InputMismatchException e) { //문자가 입력된 경우
                System.out.println("[ERROR]숫자로 입력해주세요. 다시 입력해주세요.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); //무한루프돌아서 적용;
            }

        }

    }
}
