package rpn;

import java.util.*;

public class Polish {
    public static int evaluate(String expression) throws Exception {
        String[] array = expression.split(" ");
        List<String> list = new ArrayList(Arrays.asList(array));

        return evaluate(list);
    }

    private static int evaluate(List<String> expression) throws Exception {
        for (int i = 0; i < expression.size() - 1; i++) {
            if ("+-*/".contains(expression.get(i + 2))) {
                int result = evaluateThree(expression.subList(i, i + 3));
                expression.remove(i);
                expression.remove(i);
                expression.remove(i);

                expression.add(i, String.valueOf(result));

                i = -1;
            }

        }

        return Integer.valueOf(expression.get(0));
    }

    private static int evaluateThree(List<String> expression) throws Exception {
        switch (expression.get(2)) {
            case "+":
                return Integer.valueOf(expression.get(0)) + Integer.valueOf(expression.get(1));
            case "-":
                return Integer.valueOf(expression.get(0)) - Integer.valueOf(expression.get(1));
            case "*":
                return Integer.valueOf(expression.get(0)) * Integer.valueOf(expression.get(1));
            case "/":
                if (expression.get(1).equals("0")) {
                    throw new Exception("Cannot divide by 0");
                }

                return Integer.valueOf(expression.get(0)) / Integer.valueOf(expression.get(1));
        }

        return 0;
    }
}