import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day09 {
    List<int[]> input = new ArrayList<>();
    int width;
    int extendedWidth;


    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();
            if (input.isEmpty()) {
                width = current.length();
                extendedWidth = width + 2;
                addArrayWith9s();
            }

            int[] array = new int[extendedWidth];
            array[0] = 9;
            array[extendedWidth - 1] = 9;
            for (int i = 0; i < current.length(); i++) {
                array[i + 1] = Integer.valueOf("" + current.charAt(i));
            }
            input.add(array);
        }
        addArrayWith9s();


        return calculateResult() + "";
    }

    private long calculateResult() {
        long result = 0;

        for (int i = 1; i < input.size() - 1; i++) {
            for (int j = 1; j < extendedWidth - 1; j++) {
                if (isLocalMin(i, j)) {
                    result += input.get(i)[j] + 1;
                }
            }
        }

        return result;
    }

    private boolean isLocalMin(int i, int j) {
        var current = input.get(i)[j];

        boolean b = current < input.get(i - 1)[j] &&
                current < input.get(i + 1)[j] &&
                current < input.get(i)[j - 1] &&
                current < input.get(i)[j + 1];
        return b;
    }


    private void addArrayWith9s() {
        int[] array = new int[extendedWidth];
        Arrays.fill(array, 9);
        input.add(array);
    }

}
