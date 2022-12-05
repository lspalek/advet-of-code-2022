import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day10bTest {

    private Day10b program = new Day10b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day10b-example.txt")).isEqualTo("288957");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day10b.txt")).isEqualTo("");
    }

}