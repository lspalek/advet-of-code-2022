import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day10b {

    Stack<Character> stk = new Stack<>();
    List<Long> scores = new ArrayList<>();

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();
            Long lineScore = findError(current.toCharArray());
            if (lineScore > 0) scores.add(lineScore);
        }

        Collections.sort(scores);
        return scores.get(scores.size() / 2) + "";
    }

    Long findError(char[] chars) {
        stk.clear();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                case '[':
                case '{':
                case '<':
                    stk.push(chars[i]);
                    break;
                case ')':
                    if (stk.peek() == '(') {
                        stk.pop();
                    } else {
                        return -3l;
                    }
                    break;
                case ']':
                    if (stk.peek() == '[') {
                        stk.pop();
                    } else {
                        return -57l;
                    }
                    break;
                case '}':
                    if (stk.peek() == '{') {
                        stk.pop();
                    } else {
                        return -1197l;
                    }
                    break;
                case '>':
                    if (stk.peek() == '<') {
                        stk.pop();
                    } else {
                        return -25137l;
                    }
                    break;

            }
        }


        return calculateScore(stk);
    }

    private Long calculateScore(Stack<Character> stk) {
        long result = 0;

        while (!stk.isEmpty()) {
            result *= 5;
            switch (stk.pop()) {
                case '(':
                    result += 1;
                    break;
                case '[':
                    result += 2;
                    break;
                case '{':
                    result += 3;
                    break;
                case '<':
                    result += 4;
                    break;
            }
        }

        return result;
    }

}
