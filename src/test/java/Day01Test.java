import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day01Test {

    private Day01 program = new Day01();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day01-example.txt")).isEqualTo("24000");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day01.txt")).isEqualTo("67633");
    }

}