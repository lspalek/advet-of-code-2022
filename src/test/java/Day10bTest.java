import org.junit.Test;

public class Day10bTest {

    private Day10b program = new Day10b();

    @Test
    public void shouldRunOnExample() {
        program.calculate("day10b-example.txt");
    }

    @Test
    public void shouldRunOn1Sample() {
        program.calculate("day10b.txt");
    }

}