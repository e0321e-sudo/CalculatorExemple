package updowngame;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("==== UP DOWN GAME START! ====");

        int ranNum = random.nextInt(100) + 1;
        System.out.println("랜덤 번호가 정해졌습니다.( 1 ~ 100 )");
        System.out.println("              ⇩              ");

        boolean run1 = true;
        while (run1) {
            try {
                System.out.print("번호 입력 > ");
                int num = sc.nextInt();
                if (num == ranNum) {
                    System.out.println("----축하합니다! 정답입니다 *^^*----");
                    run1 = false;
                } else if (num < ranNum) {
                    System.out.println("======> UP!!   ");
                    continue;
                } else if (num > ranNum) {
                    System.out.println("======> DOWN!!  ");
                    continue;
                } else if (!sc.hasNextInt()) {
                    throw new IllegalArgumentException();
                }
                System.out.print("한번 더 하시겠습니까? ( 0 입력시 종료 / 아무거나 입력시 한번 더! )");
                int choice = sc.nextInt();
                if (choice == 0) {
                    System.out.println("====  종 료 되 었 습 니 다.  ====");
                    run1 = false;
                }
            }catch (InputMismatchException e){
                System.out.println("====   x 숫자만 입력하세요!  ====");
                sc.next();
                continue;
            } catch (IllegalArgumentException e){
                System.out.println("== 1 과 2 중에 하나만 입력하세요 ==");
                sc.next();
                continue;
            }
        }sc.close();
    }
}