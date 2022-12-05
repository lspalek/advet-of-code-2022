import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day12Test {

    private Day12 program = new Day12();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day12-example.txt")).isEqualTo("");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day12.txt")).isEqualTo("");
    }

}