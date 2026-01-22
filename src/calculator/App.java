package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Integer> arithmeticCalculator = new ArithmeticCalculator<>();
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
                String operator = sc.next();
                OperatorType type = OperatorType.fromSymbol(operator);

                double result = arithmeticCalculator.calculate(num1, num2, type);
                System.out.println("결과: " + result);
                System.out.println("누적결과: " + arithmeticCalculator.getResults());
                System.out.println();

                boolean run1 = true;
                while (run1) {
                    System.out.println("더 계산하시겠습니까?(exit [종료] / remove [누적결과 첫 번째 삭제] / clear [누적결과 초기화] / 아무거나 입력시 [계속])");
                    String want = sc.next();
                    if ("exit".equals(want)) {
                        System.out.println("계 산 기 프 로 그 램 종 료 ^_^");
                        run = false; break;
                    } else if ("remove".equals(want)) {
                        arithmeticCalculator.remove();
                        System.out.println("삭제 후 누적결과: " + arithmeticCalculator.getResults());
                        continue;
                    } else if ("clear".equals(want)) {
                        arithmeticCalculator.clear();
                        System.out.println("초기화 후 누적결과: " + arithmeticCalculator.getResults());
                        continue;
                    } else {
                        run1 = false;
                    }
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        sc.close();
    }
}
