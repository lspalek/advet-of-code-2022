import org.junit.Test;

public class Day10Test {

    private Day10 program = new Day10();

    @Test
    public void shouldRunOnExample() {
        program.calculate("day10-example.txt");
    }

    @Test
    public void shouldRunOn1Sample() {
        program.calculate("day10.txt");
    }

}