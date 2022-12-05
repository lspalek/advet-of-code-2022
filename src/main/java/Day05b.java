import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day05b {
    List<Character>[] stacks;

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.charAt(0) != '[') {
                break;
            }
            String[] row = nextLine.split(" ");
            if (stacks == null) {
                stacks = new List[row.length];
                for (int i = 0; i < row.length; i++) {
                    stacks[i] = new ArrayList<>();
                }
            }
            for (int i = 0; i < row.length; i++) {
                char c = row[i].charAt(1);
                if (c != '.') {
                    stacks[i].add(c);
                }
            }
        }

        String nextLine = scanner.nextLine();
        while (scanner.hasNextLine()) {
            nextLine = scanner.nextLine();
            String[] row = nextLine.split(" ");

            move(Integer.parseInt(row[1]), Integer.parseInt(row[3]), Integer.parseInt(row[5]));
        }
        return calculateTops() + "";

    }

    private String calculateTops() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stacks.length; i++) {
            sb.append(stacks[i].get(0));
        }

        return sb.toString();
    }

    private void move(int count, int from, int to) {
        for (int i = count - 1; i >= 0; i--) {
            var item = stacks[from - 1].get(i);
            stacks[from - 1].remove(i);
            stacks[to - 1].add(0, item);
        }
    }
}
