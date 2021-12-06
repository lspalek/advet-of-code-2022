import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day06 {
    private List<Integer> input = new ArrayList<>();

    public String calculate(String fileName, int simulationTimeInDays) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        input = Arrays.stream(scanner.nextLine().split(",")).map(Integer::valueOf).collect(Collectors.toList());

        for (int day = 1; day <= simulationTimeInDays; day++) {
            int currentNumberOfFishes = input.size();
            for (int i = 0; i < currentNumberOfFishes; i++) {
                if (input.get(i) == 0) {
                    input.set(i, 6);
                    input.add(8);
                } else {
                    input.set(i, input.get(i) - 1);
                }
            }
            if (day % 20 == 0) {
                System.out.println(input.size());
            }
        }


        return input.size() + "";
    }

}
