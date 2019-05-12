package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMultipleNumbers {

    /**
     * 1+1+1
     */
    @Test
    public void
    should_return_3_when_1_1_plus_1_() throws Exception {
        String result = Polish.evaluate("1 1 + 1 +");

        assertThat(result).isEqualTo("3");
    }

    /**
     * 10+10+10+10
     */
    @Test
    public void
    should_return_50_when_10_10_plus_10_plus_10_plus() throws Exception {
        String result = Polish.evaluate("10 10 + 10 + 10 +");

        assertThat(result).isEqualTo("40");
    }

    /**
     * 10+10+10+10+20
     */
    @Test public void
    should_return_50_when_10_10_plus_10_plus_10_plus_20_plus() throws Exception {
        String result = Polish.evaluate("10 10 + 10 + 10 + 20 +");

        assertThat(result).isEqualTo("60");
    }

    /**
     * 5-(2*3)
     */
    @Test public void
    should_return_0_when_5_2_3_plus_minus() throws Exception {
        String result = Polish.evaluate("5 2 3 + -");

        assertThat(result).isEqualTo("0");
    }

    /**
     * 3*((5*8)+7)
     */
    @Test public void
    should_return_141_when_3_5_8_times_7_plus_times() throws Exception {
        String result = Polish.evaluate("3 5 8 * 7 + *");

        assertThat(result).isEqualTo("141");
    }

    /**
     * 7 2 - 3 4
     */
    @Test public void
    should_return_5_3_4_when_7_2_minus_3_4() throws Exception {
        String result = Polish.evaluate("7 2 - 3 4");

        assertThat(result).isEqualTo("5 3 4");
    }

    /**
     * 5 6 * 8 9 * 9 6 -
     */
    @Test public void
    should_return_30_72_3_when_5_6_times_8_9_times_9_6_minus() throws Exception {
        String result = Polish.evaluate("5 6 * 8 9 * 9 6 -");

        assertThat(result).isEqualTo("30 72 3");
    }
}