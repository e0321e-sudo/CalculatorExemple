package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello, Calculation!!");

        boolean run = true;
        while (run) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                if (!sc.hasNextInt()) {
                    System.out.println("----숫자만 입력하세요----!");
                    sc.next();
                    continue;
                }
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                if (!sc.hasNextInt()) {
                    System.out.println("----숫자만 입력하세요----!");
                    sc.next();
                    continue;
                }
                int num2 = sc.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
                System.out.println("누적결과: " + calculator.getResults());
                System.out.println();
                System.out.println("더 계산하시겠습니까?(exit 입력시 [종료] / c 입력 시 [누적결과 초기화] / 아무거나 입력 시 [계속])");
                String exit = sc.next();
                if ("exit".equals(exit)) {
                    System.out.println("계 산 기 프 로 그 램 종 료 ^_^");
                    run = false;
                } else if ("c".equals(exit)) {
                    calculator.c();
                    System.out.println("기존 누적결과가 초기화되었습니다!0ㅁ0");
                    System.out.println("누적결과: " + calculator.getResults());
                    continue;
                }
            }
            catch (ArithmeticException | IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
        sc.close();
    }
}
