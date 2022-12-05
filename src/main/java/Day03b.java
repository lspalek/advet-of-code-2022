import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day03b {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        long totalPriority = 0;

        while (scanner.hasNextLine()) {
            var commonItem = findCommonItem(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
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

        throw new RuntimeException("wrong character: " + item);
    }

    char findCommonItem(String s1, String s2, String s3) {
        Set<Character> set1 = toSet(s1);
        Set<Character> set2 = toSet(s2);
        Set<Character> set3 = toSet(s3);
        for (Character c : set1) {
            if (set2.contains(c) && set3.contains(c)) {
                return c;
            }
        }
        throw new RuntimeException("not found common item");
    }

    private Set<Character> toSet(String s1) {
        Set<Character> result = new HashSet<>();
        for (char c : s1.toCharArray()) {
            result.add(c);
        }
        return result;
    }

}
