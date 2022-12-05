import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day08bTest {

    private Day08b program = new Day08b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day08b-example.txt")).isEqualTo("61229");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day08b.txt")).isEqualTo("908067");
    }

}