import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day21bTest {

    private Day21b program = new Day21b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day21b-example.txt")).isEqualTo("");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day21b.txt")).isEqualTo("");
    }

}