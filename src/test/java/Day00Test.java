import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day00Test {

    private Day00 program = new Day00();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day00-example.txt")).isEqualTo("");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day00.txt")).isEqualTo("");
    }

}