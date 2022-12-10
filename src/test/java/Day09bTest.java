import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day09bTest {

    private Day09b program = new Day09b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day09b-example.txt")).isEqualTo("1");
    }

    @Test
    public void shouldRunOnExample2() {
        then(program.calculate("day09b-example2.txt")).isEqualTo("36");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day09b.txt")).isEqualTo("2557");
    }

}