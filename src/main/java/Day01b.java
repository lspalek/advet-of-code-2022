import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day01b {
    private List<Integer> input = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Day01b().calculate("day01b-example.txt"));

    }

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        Integer increaseCount = 0;
        input.add(scanner.nextInt());
        input.add(scanner.nextInt());
        input.add(scanner.nextInt());
        while (scanner.hasNextInt()) {
            var current = scanner.nextInt();
            if (input.get(0) < current) increaseCount++;
            input.add(current);
            input.remove(0);
        }
        return increaseCount + "";
    }

}
