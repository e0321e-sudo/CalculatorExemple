package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator <T extends Number>{
    private List<Double> results = new ArrayList<>();

    public double calculate(T num1, T num2, OperatorType type) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();
        double result = type.apply(a, b);

        results.add(result);
        return result;
    }

    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    public void clear() {
        results.clear();
        System.out.println("누적결과가 초기화되었습니다!0ㅁ0");
    }
    public void remove(){
        if(results.isEmpty()){
            System.out.println("x 삭제할 누적 결과가 없습니다.");
            return;
        } results.remove(0);
    }
}