import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day03Test {

    private Day03 program = new Day03();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day03-example.txt")).isEqualTo("198");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day03.txt")).isEqualTo("3374136");
    }

}