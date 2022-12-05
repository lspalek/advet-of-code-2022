import java.util.Scanner;
import java.util.Stack;

public class Day10 {

    Stack<Character> stk = new Stack<>();

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        Long result = 0l;
        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();
            result += findError(current.toCharArray());
        }
        return result + "";
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
                        return 3l;
                    }
                    break;
                case ']':
                    if (stk.peek() == '[') {
                        stk.pop();
                    } else {
                        return 57l;
                    }
                    break;
                case '}':
                    if (stk.peek() == '{') {
                        stk.pop();
                    } else {
                        return 1197l;
                    }
                    break;
                case '>':
                    if (stk.peek() == '<') {
                        stk.pop();
                    } else {
                        return 25137l;
                    }
                    break;

            }
        }

        return 0l;

    }

}
