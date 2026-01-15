package example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        boolean run = true;
        while (run) {
            try {
                System.out.print("첫 번째 정수를 입력하세요: ");
                int num1 = sc.nextInt();

                System.out.print("두 번째 정수를 입력하세요: ");
                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
                System.out.println("누적 결과: " + calculator.getResults());

                System.out.println("명령어 입력 (clear: 초기화 remove: 첫 결과 삭제 enter: 계속)");
                String commend = sc.nextLine();
                if ("clear".equals(commend)) {
                    calculator.setResults(new ArrayList<>());
                    System.out.println("초기화 후: " + calculator.getResults());
                } else if ("remove".equals(commend)){
                    calculator.removeResult();
                    System.out.println("삭제 후: " + calculator.getResults());
                } else {
                }

                System.out.println("더 입력 하시겠습니까? (exit 입력 시 종료됩니다)");
                String exit = sc.next();
                if ("exit".equals(exit)) {
                    run = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력하세요!");
                sc.nextLine();
                continue;
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

        }
        sc.close();
    }

}