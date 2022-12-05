import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day25Test {

    private Day25 program = new Day25();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day25-example.txt")).isEqualTo("58");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day25.txt")).isEqualTo("");
    }

}