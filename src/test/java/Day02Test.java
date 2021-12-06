import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day02Test {

    private Day02 program = new Day02();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day02-example.txt")).isEqualTo("150");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day02.txt")).isEqualTo("1459206");
    }

}