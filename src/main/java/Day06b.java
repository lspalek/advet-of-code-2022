import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day06b {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        var s = scanner.nextLine();

        Set<Character> differentCharacters = new HashSet<>();
        for (int i = 13; i < s.length(); i++) {
            differentCharacters.clear();
            for (int j = 0; j < 14; j++) {
                differentCharacters.add(s.charAt(i - j));
            }

            if (differentCharacters.size() == 14) {
                return i + 1 + "";
            }
        }
        return 0 + "";
    }

}
