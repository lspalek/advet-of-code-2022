import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day02bTest {

    private Day02b program = new Day02b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day02-example.txt")).isEqualTo("900");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day02.txt")).isEqualTo("1320534480");
    }

}