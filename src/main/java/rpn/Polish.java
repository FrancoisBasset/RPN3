package rpn;

import java.util.*;

public class Polish {
    private Polish() {

    }

    public static String evaluate(String expression) throws ArithmeticException {
        String[] array = expression.split(" ");
        List<String> list = new ArrayList(Arrays.asList(array));

        return evaluate(list);
    }

    private static String evaluate(List<String> expression) throws ArithmeticException {
        for (int i = 0; i < expression.size() - 1; i++) {
            if (i + 2 >= expression.size()) {
                StringBuilder stringExpression = new StringBuilder();

                for (String s : expression) {
                    stringExpression.append(s);
                    stringExpression.append(" ");
                }

                return stringExpression.toString().trim();
            }

            if ("+-*/".contains(expression.get(i + 2))) {
                String result = evaluateThree(expression.subList(i, i + 3));
                expression.remove(i);
                expression.remove(i);
                expression.remove(i);

                expression.add(i, result);

                i = -1;
            }

        }

        return expression.get(0);
    }

    private static String evaluateThree(List<String> expression) throws ArithmeticException {
        float result = 0;

        switch (expression.get(2)) {
            case "+":
                result = Float.valueOf(expression.get(0)) + Float.valueOf(expression.get(1));
                break;
            case "-":
                result = Float.valueOf(expression.get(0)) - Float.valueOf(expression.get(1));
                break;
            case "*":
                result = Float.valueOf(expression.get(0)) * Float.valueOf(expression.get(1));
                break;
            case "/":
                if (expression.get(1).equals("0")) {
                    throw new ArithmeticException("Cannot divide by 0");
                }

                result = Float.valueOf(expression.get(0)) / Float.valueOf(expression.get(1));
                break;
        }

        if (result % 1 == 0) {
            return String.valueOf((int) result);
        }

        return String.valueOf(result);
    }
}