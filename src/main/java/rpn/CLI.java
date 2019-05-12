package rpn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        try {
            String result = Polish.evaluate(expression);

            System.out.println("About to evaluate '" + expression + "'");
            System.out.println("> " + result);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}