import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day01bTest {

    private Day01b program = new Day01b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day01b-example.txt")).isEqualTo("45000");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day01b.txt")).isEqualTo("199628");
    }

}