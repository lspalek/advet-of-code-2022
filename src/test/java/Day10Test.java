import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day10Test {

    private Day10 program = new Day10();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day10-example.txt")).isEqualTo("26397");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day10.txt")).isEqualTo("");
    }

}