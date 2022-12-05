import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day07Test {

    private Day07 program = new Day07();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day07-example.txt")).isEqualTo("37");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day07.txt")).isEqualTo("352254");
    }

}