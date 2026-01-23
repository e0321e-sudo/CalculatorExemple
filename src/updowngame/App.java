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

        boolean run1 = true;
        while (run1) {
            try {
                System.out.println("입력을 시작하시겠습니까? [1. Go! / 2. Stop!]");
                int choice = sc.nextInt();
                if (choice == 2) {
                    System.out.println("====  종 료 되 었 습 니 다.  ====");
                    run1 = false;
                } else if (choice == 1) {
                    boolean run2 = true;
                    while (run2) {
                        System.out.print("번호 입력 > ");
                        int num = sc.nextInt();
                        if (num == ranNum) {
                            System.out.println("----축하합니다! 정답입니다 *^^*----");
                            run2 = false;
                            break;
                        } else {
                            if (num < ranNum) {
                                System.out.println("    UP!!   ");
                            } else if (num > ranNum) {
                                System.out.println("   DOWN!!  ");
                            }
                        }
                    }
                } else if (choice != 1 || choice != 2) {
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException e){
                System.out.println("====   x 숫자만 입력하세요!  ====");
                break;
            } catch (IllegalArgumentException e){
                System.out.println("== 1 과 2 중에 하나만 입력하세요 ==");
                continue;
            }
        }sc.close();
    }
}