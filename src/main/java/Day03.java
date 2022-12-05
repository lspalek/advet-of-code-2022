import java.util.Scanner;

public class Day03 {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        long totalPriority = 0;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            var commonItem = findCommonItem(s);
            totalPriority += calculatePriorirty(commonItem);
        }

        return totalPriority + "";
    }

    private int calculatePriorirty(char item) {
        if (item >= 'a' && item <= 'z') {
            return ((int) item) - ((int) 'a') + 1;
        }

        if (item >= 'A' && item <= 'Z') {
            return ((int) item) - ((int) 'A') + 27;
        }

        throw new RuntimeException("wront character: " + item);
    }

    char findCommonItem(String s) {
        int halfSize = s.length() / 2;
        for (int i = 0; i < halfSize; i++) {
            for (int j = halfSize; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return s.charAt(i);
                }
            }
        }
        throw new RuntimeException("not found common item");
    }

}
