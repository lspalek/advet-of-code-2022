import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day06Test {

    private Day06 program = new Day06();

    @Test
    public void shouldRunOnExample18Days() {
        then(program.calculate("day06-example.txt", 18)).isEqualTo("26");
    }

    @Test
    public void shouldRunOnExample80Days() {
        then(program.calculate("day06-example.txt", 80)).isEqualTo("5934");
    }

    @Test
    public void shouldRunOnExample256Days() {
        then(program.calculate("day06-example.txt", 256)).isEqualTo("26984457539");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day06.txt", 80)).isEqualTo("351188");
    }

}