import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Day09b {
    List<int[]> input = new ArrayList<>();
    boolean[][] basin;
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
        List<Long> basinSizes = new ArrayList<>();

        for (int i = 1; i < input.size() - 1; i++) {
            for (int j = 1; j < extendedWidth - 1; j++) {
                if (isLocalMin(i, j)) {
                    clearBasin();
                    basinSizes.add(calculateBasin(i, j));
                }
            }
        }

        return basinSizes.stream().sorted(Comparator.reverseOrder()).limit(3).reduce(1l, (a, b) -> a * b);
    }

    private long calculateBasin(int i, int j) {
        basin[i][j] = true;
        var current = input.get(i)[j];
        long up = calculateIfITBelongsInBasin(i - 1, j, current);
        long down = calculateIfITBelongsInBasin(i + 1, j, current);
        long left = calculateIfITBelongsInBasin(i, j - 1, current);
        long right = calculateIfITBelongsInBasin(i, j + 1, current);


        long result = 1 + up + down + left + right;


        return result;
    }

    private long calculateIfITBelongsInBasin(int i, int j, int current) {
        if (!basin[i][j] && input.get(i)[j] < 9 && input.get(i)[j] > current) {
            return calculateBasin(i, j);
        }
        return 0;
    }

    private boolean isLocalMin(int i, int j) {
        var current = input.get(i)[j];

        boolean b = current < input.get(i - 1)[j] &&
                current < input.get(i + 1)[j] &&
                current < input.get(i)[j - 1] &&
                current < input.get(i)[j + 1];
        return b;
    }

    private void clearBasin() {
        basin = new boolean[input.size()][extendedWidth];
    }


    private void addArrayWith9s() {
        int[] array = new int[extendedWidth];
        Arrays.fill(array, 9);
        input.add(array);
    }

}
