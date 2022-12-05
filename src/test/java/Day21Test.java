import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day21Test {

    private Day21 program = new Day21();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day21-example.txt")).isEqualTo("");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day21.txt")).isEqualTo("");
    }

}