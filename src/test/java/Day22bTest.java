import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day22bTest {

    private Day22b program = new Day22b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day22b-example.txt")).isEqualTo("39");
    }
    @Test
    public void shouldRunOnExample2() {
        then(program.calculate("day22b-example2.txt")).isEqualTo("590784");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day22b.txt")).isEqualTo("");
    }

}