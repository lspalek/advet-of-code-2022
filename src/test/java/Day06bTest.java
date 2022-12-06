import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day06bTest {

    private Day06b program = new Day06b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day06b-example.txt")).isEqualTo("19");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day06b.txt")).isEqualTo("2421");
    }

}