import java.util.Scanner;

public class Day02b {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        Integer depth = 0;
        Integer distance = 0;
        Integer aim = 0;
        while (scanner.hasNextLine()) {
            var command = scanner.next("\\b(?:forward|down|up)\\b");
//            System.out.println(command);
            var number = scanner.nextInt();
//            System.out.println(number);
            switch (command) {
                case "forward":
                    depth += number*aim;
                    distance += number;
                    break;
                case "down":
                    aim += number;
                    break;
                case "up":
                    aim -= number;
                    break;
            }
        }
        return depth * distance + "";
    }

}
