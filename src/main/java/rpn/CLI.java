package rpn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        /*String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        long result = evaluate(expression);
        System.out.println("> " + result);*/

        String expression = "3 5 8 * 7 + *";

        try {
            System.out.println(Polish.evaluate(expression));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
