import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.*;

import org.junit.Test;

public class Day05Test {

    private Day05 program = new Day05();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day05-example.txt")).isEqualTo("5");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day05.txt")).isEqualTo("5576");
    }

}