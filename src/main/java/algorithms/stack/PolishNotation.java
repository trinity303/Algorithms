package algorithms.stack;

import java.io.IOException;
import java.util.Stack;

class PolishNotation {

    private static final Reader reader = new Reader();
    private static final Stack<Integer> stack = new Stack<>();

    private static final Handler handler = new Handler() {
        @Override
        public void handleOperand(int value) {
            stack.push(value);
        }

        @Override
        public void handleOperationSign(String sign) {
            switch (sign) {
                case "+" -> addition();
                case "-" -> subtraction();
                case "*" -> multiplication();
                case "/" -> division();
            }
        }
    };

    public static void main(String[] args) throws IOException {
        reader.read(handler);

        System.out.println(stack.pop());
    }

    private static void addition() {
        int operand1 = stack.pop();
        int operand2 = stack.pop();
        stack.push(operand1 + operand2);
    }

    private static void subtraction() {
        int operand1 = stack.pop();
        int operand2 = stack.pop();
        stack.push(operand2 - operand1);
    }

    private static void multiplication() {
        int operand1 = stack.pop();
        int operand2 = stack.pop();
        stack.push(operand2 * operand1);
    }

    private static void division() {
        double operand1 = stack.pop();
        double operand2 = stack.pop();
        double result = Math.floor(operand2 / operand1);
        stack.push((int) result);
    }
}
