import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day06Test {

    private Day06 program = new Day06();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day06-example.txt")).isEqualTo("7");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day06.txt")).isEqualTo("1100");
    }

}