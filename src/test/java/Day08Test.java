import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day08Test {

    private Day08 program = new Day08();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day08-example.txt")).isEqualTo("21");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day08.txt")).isEqualTo("1854");
    }

}