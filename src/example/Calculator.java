package example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("첫 번째 정수를 입력하세요: ");
            int num1 = scanner.nextInt();
            System.out.print("두 번째 정수를 입력하세요: ");
            int num2 = scanner.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            int result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("올바른 연산자가 아닙니다.");
                    continue;
            }
            System.out.println("결과: " + result);

            System.out.println("더 입력 하시겠습니까? (exit 입력 시 종료됩니다.)");
            String exit = scanner.next();
            if (exit.equals("exit")) {
                break;
            }
        }

    }
}