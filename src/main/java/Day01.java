import java.util.Scanner;

public class Day01 {
//    private List<Integer> input = new ArrayList<>();

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        Integer increaseCount = 0;
        Integer previous = null;
        while (scanner.hasNextInt()) {
            var current = scanner.nextInt();
            if (previous != null && previous < current) increaseCount++;
            previous = current;
        }
        return increaseCount + "";
    }

}
