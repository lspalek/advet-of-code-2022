import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day07bTest {

    private Day07b program = new Day07b();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day07b-example.txt")).isEqualTo("24933642");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day07b.txt")).isEqualTo("3979145");
    }

}