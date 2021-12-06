import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.*;

import org.junit.Test;

public class Day04bTest {

    private Day04b program = new Day04b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day04b-example.txt")).isEqualTo("1924");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day04b.txt")).isEqualTo("1665");
    }

}