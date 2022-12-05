import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

public class Day08b {
    Digit[] numbers = new Digit[10];
    List<String> input = new ArrayList<>();
    List<String> output = new ArrayList<>();

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        var counter = 0;
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();

            input = new ArrayList<>(List.of(line.split(" \\| ")[0].split(" ")));
            output = List.of(line.split(" \\| ")[1].split(" "));

            input.sort((o1, o2) -> o1.length() - o2.length());

            assert input.get(0).length() == 2;
            assert input.get(1).length() == 3;
            assert input.get(2).length() == 4;
            assert input.get(3).length() == 5;
            assert input.get(4).length() == 5;
            assert input.get(5).length() == 5;
            assert input.get(6).length() == 6;
            assert input.get(7).length() == 6;
            assert input.get(8).length() == 6;
            assert input.get(9).length() == 7;

            numbers[1] = new Digit(toCharSet(input.get(0)));
            numbers[7] = new Digit(toCharSet(input.get(1)));
            numbers[4] = new Digit(toCharSet(input.get(2)));
            numbers[8] = new Digit(toCharSet(input.get(9)));

            calculate6And9And0();
            calculate2And3And5();

            counter += countResult(output);
        }
        return counter + "";
    }

    /**
     * 6, 9,0 are at indexes: 6 - 8 in input field
     */
    private void calculate6And9And0() {

        List<Digit> unknown = new ArrayList<>(List.of(new Digit(toCharSet(input.get(6))),
                new Digit(toCharSet(input.get(7))),
                new Digit(toCharSet(input.get(8)))));

        for (Digit maybe6 : unknown) {
            if (!maybe6.segments.containsAll(numbers[1].segments)) {
                numbers[6] = maybe6;
                unknown.remove(maybe6);
                break;
            }
        }

        for (Digit maybe9 : unknown) {
            if (maybe9.segments.containsAll(numbers[4].segments)) {
                numbers[9] = maybe9;
                unknown.remove(maybe9);
                break;
            }
        }

        assert unknown.size() == 1;
        numbers[0] = unknown.get(0);
    }

    /**
     * 2,3,5 are at indexes: 3 - 5 in input field
     */
    private void calculate2And3And5() {

        List<Digit> unknown = new ArrayList<>(List.of(new Digit(toCharSet(input.get(3))),
                new Digit(toCharSet(input.get(4))),
                new Digit(toCharSet(input.get(5)))));

        for (Digit maybe3 : unknown) {
            if (maybe3.segments.containsAll(numbers[1].segments)) {
                numbers[3] = maybe3;
                unknown.remove(maybe3);
                break;
            }
        }

        for (Digit maybe5 : unknown) {
            if (numbers[6].segments.containsAll(maybe5.segments)) {
                numbers[5] = maybe5;
                unknown.remove(maybe5);
                break;
            }
        }

        assert unknown.size() == 1;
        numbers[2] = unknown.get(0);

    }

    private Set<Character> toCharSet(String s) {
        return s.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
    }

    private int countResult(List<String> numberList) {
        var counter = "";

        for (String singleNumber : numberList) {
            Set<Character> characters = toCharSet(singleNumber);

            for (int i = 0; i < 10; i++) {
                if (numbers[i].segments.equals(characters)) {
                    counter += i;
                    break;
                }
            }
        }
        return Integer.valueOf(counter);
    }

    @AllArgsConstructor
    class Digit {
        Set<Character> segments;
    }

    String a = "0,9 -> 5,9\n" +
            "8,0 -> 0,8\n" +
            "9,4 -> 3,4\n" +
            "2,2 -> 2,1\n" +
            "7,0 -> 7,4\n" +
            "6,4 -> 2,0\n" +
            "0,9 -> 2,9\n" +
            "3,4 -> 1,4\n" +
            "0,0 -> 8,8\n" +
            "5,5 -> 8,2";
}
