import static org.assertj.core.api.BDDAssertions.then;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

public class Day03bTest {

    private Day03b program = new Day03b();

    @Test
    public void shouldRunOnExample() throws IOException, URISyntaxException {
        then(program.calculate("day03b-example.txt")).isEqualTo("70");
    }

    @Test
    public void shouldRunOn1Sample() throws IOException, URISyntaxException {
        then(program.calculate("day03b.txt")).isEqualTo("2342");
    }

}