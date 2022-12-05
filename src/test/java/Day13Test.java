import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day13Test {

    private Day13 program = new Day13();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day13-example.txt")).isEqualTo("17");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day13.txt")).isEqualTo("");
    }

}