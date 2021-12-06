import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.*;

import org.junit.Test;

public class Day04Test {

    private Day04 program = new Day04();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day04-example.txt")).isEqualTo("4512");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day04.txt")).isEqualTo("1665");
    }

}