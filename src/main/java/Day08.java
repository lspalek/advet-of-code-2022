import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import lombok.AllArgsConstructor;

public class Day08 {
    Digit[] numbers = define();
    List<String> input = new ArrayList<>();
    List<String> output = new ArrayList<>();


    private Digit[] define() {
        Digit[] result = new Digit[10];
        result[0] = new Digit(Set.of('a', 'b', 'c', 'e', 'f', 'g'));
        result[1] = new Digit(Set.of('c', 'f'));
        result[2] = new Digit(Set.of('a', 'c', 'd', 'e', 'g'));
        result[3] = new Digit(Set.of('a', 'c', 'd', 'f', 'g'));
        result[4] = new Digit(Set.of('b', 'c', 'd', 'f'));
        result[5] = new Digit(Set.of('a', 'b', 'd', 'f', 'g'));
        result[6] = new Digit(Set.of('a', 'b', 'd', 'e', 'f', 'g'));
        result[7] = new Digit(Set.of('a', 'c', 'f'));
        result[8] = new Digit(Set.of('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        result[9] = new Digit(Set.of('a', 'b', 'c', 'd', 'f', 'g'));

        return result;

    }

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        var counter = 0;
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();
            input = List.of(line.split(" \\| ")[0].split(" "));
            output = List.of(line.split(" \\| ")[1].split(" "));

            counter += count1478(output);
        }
        return counter + "";
    }

    private int count1478(List<String> numberList) {
        var counter = 0;
        Set<Integer> expectedLength = Set.of(2, 4, 3, 7);
        for (String singleNumber : numberList) {
            if (expectedLength.contains(singleNumber.length())) {
                counter++;
            }
        }
        return counter;
    }


    @AllArgsConstructor
    class Digit {
        Set<Character> segments;
    }

}
