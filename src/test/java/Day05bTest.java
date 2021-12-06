import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.*;

import org.junit.Test;

public class Day05bTest {

    private Day05b program = new Day05b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day05b-example.txt")).isEqualTo("12");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day05b.txt")).isEqualTo("18144");
    }

}