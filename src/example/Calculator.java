package example;

import java.util.ArrayList;

public class Calculator {

        private ArrayList<Integer> results = new ArrayList<>();

        public int calculate(int num1, int num2, char operator){
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
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                    }
                    result = num1 / num2;
                    break;

            default:
                throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
        }
            results.add(result);
            return result;
        }
    }
