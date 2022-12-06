import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day06 {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        var s = scanner.nextLine();

        Set<Character> differentCharacters = new HashSet<>();
        for (int i = 3; i < s.length(); i++) {
            differentCharacters.clear();
            differentCharacters.add(s.charAt(i));
            differentCharacters.add(s.charAt(i - 1));
            differentCharacters.add(s.charAt(i - 2));
            differentCharacters.add(s.charAt(i - 3));

            if (differentCharacters.size() == 4) {
                return i + 1 + "";
            }
        }
        return 0 + "";
    }

}
