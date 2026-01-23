package updowngame;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("==== UP DOWN GAME START! ====");

        boolean replay = true;
        while (replay) {
            int ranNum = random.nextInt(100) + 1;
            System.out.println("랜덤 번호가 정해졌습니다.( 1 ~ 100 )");
            System.out.println("              ⇩              ");

            boolean run = true;
            while (run) {
                try {
                    System.out.print("번호 입력 > ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    if (num < 1 || num > 100) {
                        throw new IllegalArgumentException("1~100 사이 숫자만 입력하세요!");
                    } else if (num < ranNum) {
                        System.out.println("======> UP!!   ");
                        continue;
                    } else if (num > ranNum) {
                        System.out.println("======> DOWN!!  ");
                        continue;
                    } else if (num == ranNum) {
                        System.out.println("----축하합니다! 정답입니다 *^^*----");
                        run = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("====   x 숫자만 입력하세요!  ====");
                    sc.next();
                    continue;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
            System.out.println("한번 더 하시겠습니까? ( end 입력시 종료 / 아무거나 입력시 한번 더  )");
            String choice = sc.next();
            if (choice.equals("end")) {
                System.out.println("====  종 료 되 었 습 니 다.  ====");
                replay = false;
            }
        }
        sc.close();
    }
}
