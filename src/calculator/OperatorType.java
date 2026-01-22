package calculator;

public enum OperatorType {
    PLUS("+"){
        @Override
        public double apply(double num1, double num2){
            return num1 + num2;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double num1, double num2){
            return num1 - num2;
        }
    },
    MULTIPLY("*"){
        @Override
        public double apply(double num1, double num2){
            return num1 * num2;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double num1, double num2){
            if(num2==0){
                throw new ArithmeticException("나눗셈에서 분모에 0이 올 수 없습니다.");
            }
            return num1 / num2;
        }
    };

    private final String symbol;
    OperatorType(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static OperatorType fromSymbol(String input){
        for(OperatorType op : OperatorType.values()){
            if(op.symbol.equals(input)){
                return op;
            }
        }
        throw new IllegalArgumentException("올바른 연산자가 아닙니다" + input);
    }

    public abstract double apply(double num1, double num2);
}

