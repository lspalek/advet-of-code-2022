import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day13bTest {

    private Day13b program = new Day13b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day13b-example.txt")).isEqualTo("17");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day13b.txt")).isEqualTo("");
    }

}