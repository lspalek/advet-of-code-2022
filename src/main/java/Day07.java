import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day07 {

    List<Integer> input = new ArrayList<>();

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        input = Arrays.stream(scanner.nextLine().split(",")).map(Integer::valueOf).collect(Collectors.toList());

        Collections.sort(input);
        var min = input.get(0);
        var max = input.get(input.size()-1);

        var  minIndex = -1;
        var minFuel = max * input.size();
        for (int i= min ; i < max; i++) {
            int current = calculateFuel(i);
            if (minFuel > current) {
                minFuel = current;
                minIndex = i;
            }
        }

        return minFuel + "";
    }

    private int calculateFuel(int x) {
        int sum = 0;
        for(int num : input) {
            sum += Math.abs(num-x);
        }
        return sum;
    }

}
