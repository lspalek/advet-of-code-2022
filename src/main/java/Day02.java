import java.util.Scanner;

public class Day02 {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        Integer depth = 0;
        Integer distance = 0;
        while (scanner.hasNextLine()) {
            var command = scanner.next("\\b(?:forward|down|up)\\b");
//            System.out.println(command);
            var number = scanner.nextInt();
//            System.out.println(number);
            switch (command) {
                case "forward":
                    distance += number;
                    break;
                case "down":
                    depth += number;
                    break;
                case "up":
                    depth -= number;
                    break;
            }
        }
        return depth * distance + "";
    }

}
