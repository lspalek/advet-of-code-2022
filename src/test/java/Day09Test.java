import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day09Test {

    private Day09 program = new Day09();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day09-example.txt")).isEqualTo("");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day09.txt")).isEqualTo("");
    }

}