package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CLITestTwoNumbers {

    /**
     * Plus
     */
    @Test public void
    should_return_3_when_1_2_plus() throws Exception {
        double result = Polish.evaluate("1 2 +");

        assertThat(result).isEqualTo(3);
    }

    @Test public void
    should_return_4_when_2_2_plus() throws Exception {
        double result = Polish.evaluate("2 2 +");

        assertThat(result).isEqualTo(4);
    }

    /**
     * Minus
     */
    @Test public void
    should_return_2_when_3_1_minus() throws Exception {
        double result = Polish.evaluate("3 1 -");

        assertThat(result).isEqualTo(2);
    }

    @Test public void
    should_return_minus5_when_0_5_minus() throws Exception {
        double result = Polish.evaluate("0 5 -");

        assertThat(result).isEqualTo(-5);
    }

    /**
     * Times
     */
    @Test public void
    should_return_30_when_5_6_times() throws Exception {
        double result = Polish.evaluate("5 6 *");

        assertThat(result).isEqualTo(30);
    }

    @Test public void
    should_return_0_when_0_10_times() throws Exception {
        double result = Polish.evaluate("0 10 *");

        assertThat(result).isEqualTo(0);
    }

    /**
     * Divided by
     */
    @Test public void
    should_return_5_when_100_20_dividedby() throws Exception {
        double result = Polish.evaluate("100 20 /");

        assertThat(result).isEqualTo(5);
    }

    @Test public void
    should_throw_exception_when_5_0_dividedby() {
        assertThatCode(() -> {
            double result = Polish.evaluate("5 0 /");
        }).hasMessage("Cannot divide by 0");
    }

    @Test public void
    should_not_throw_any_exception_when_5_1_dividedby() {
        assertThatCode(() -> {
            double result = Polish.evaluate("5 1 /");
        }).doesNotThrowAnyException();
    }


}