import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day13cTest {

    private Day13c program = new Day13c();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day13c-example.txt")).isEqualTo("17");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day13c.txt")).isEqualTo("");
    }

}