import java.util.Scanner;

public class Day10 {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        int cycle = 0;
        int x = 1;
        int sum = 0;
        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();

            if (current.startsWith("noop")) {
                cycle++;
                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                    sum += x * cycle;
                }
                continue;
            }

            if (current.startsWith("addx ")) {
                int increase = Integer.parseInt(current.replace("addx ", ""));

                if (cycle == 19 || cycle == 59 || cycle == 99 || cycle == 139 || cycle == 179 || cycle == 219) {
                    sum += (x*(cycle+1));
                }
                cycle += 2;

                if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                    sum += (x*cycle);
                }
                x += increase;
            }


        }
        System.out.println("Cycle = " + cycle);
        return sum + "";
    }

}
