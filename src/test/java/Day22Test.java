import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day22Test {

    private Day22 program = new Day22();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day22-example.txt")).isEqualTo("39");
    }
    @Test
    public void shouldRunOnExample2() {
        then(program.calculate("day22-example2.txt")).isEqualTo("590784");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day22.txt")).isEqualTo("");
    }

}