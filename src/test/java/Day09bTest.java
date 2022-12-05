import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day09bTest {

    private Day09b program = new Day09b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day09b-example.txt")).isEqualTo("1134");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day09b.txt")).isEqualTo("858494");
    }

    @Test
    public void shouldRunOn2Sample() {
        then(program.calculate("day09b-majka.txt")).isEqualTo("1103130");
    }

}