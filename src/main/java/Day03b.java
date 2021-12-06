import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class Day03b {

    public String calculate(String fileName) throws IOException, URISyntaxException {
        List<String> numbers = ImmutableList.copyOf(Files.readAllLines(Path.of(this.getClass().getResource(fileName).toURI())));

        return calculateOxygenGeneratorRating(new ArrayList(numbers)) * calculateCo2(new ArrayList<>(numbers)) + "";
    }

    private int calculateOxygenGeneratorRating(List<String> numbers) {
        int index = 0;
        do {
            applyCalculationOxygenGeneratorRating(numbers, index);
            index++;
        } while (numbers.size() > 1 && index < numbers.get(0).length());
        if (numbers.isEmpty()) throw new RuntimeException("not possible to calcualte OxygenGeneratorRating");

        return Integer.parseInt(numbers.get(0), 2);
    }

    private void applyCalculationOxygenGeneratorRating(List<String> numbers, int currentBitIndex) {
        var oneCount = calculateOnes(numbers, currentBitIndex);

        if (oneCount * 2 >= numbers.size()) {
            remove(numbers, currentBitIndex, '0');
        } else {
            remove(numbers, currentBitIndex, '1');
        }
    }

    private int calculateCo2(List<String> numbers) {
        int index = 0;
        do {
            applyCo2(numbers, index);
            index++;
        } while (numbers.size() > 1 && index < numbers.get(0).length());
        if (numbers.isEmpty()) throw new RuntimeException("not possible to calcualte OxygenGeneratorRating");

        return Integer.parseInt(numbers.get(0), 2);
    }

    private void applyCo2(List<String> numbers, int currentBitIndex) {
        var oneCount = calculateOnes(numbers, currentBitIndex);

        if (oneCount * 2 >= numbers.size()) {
            remove(numbers, currentBitIndex, '1');
        } else {
            remove(numbers, currentBitIndex, '0');
        }
    }

    private void remove(List<String> numbers, int currentBitIndex, char currentBitValueToDelete) {
        boolean somethingWasDeleted;
        do {
            somethingWasDeleted = false;
            for (String s : numbers) {
                if (s.charAt(currentBitIndex) == currentBitValueToDelete) {
                    numbers.remove(s);
                    somethingWasDeleted = true;
                    break;
                }
            }
        } while (somethingWasDeleted);
    }

    private int calculateOnes(List<String> numbers, int currentBitIndex) {
        var count = 0;
        for (String s : numbers) {
            if (s.charAt(currentBitIndex) == '1') count++;
        }

        return count;
    }

}
