import java.util.Scanner;

public class Day10b {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        int cycle = 0;
        int x = 1;
        int sum = 0;
        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();

            if (current.startsWith("noop")) {
                cycle++;
                print(cycle, x);
                continue;
            }

            if (current.startsWith("addx ")) {
                int increase = Integer.parseInt(current.replace("addx ", ""));

                cycle++;
                print(cycle, x);

                cycle++;
                print(cycle, x);

                x += increase;
            }


        }
        System.out.println("Cycle = " + cycle);
        return sum + "";
    }

    private void print(int cycle, int x) {
        int myCycle = (cycle - 1) % 40;

        if (myCycle == 0) {
            System.out.println();
        }

        if (myCycle == x || myCycle == (x - 1) || myCycle == (x + 1)) {
            System.out.print("#");
        } else {
            System.out.print(".");
        }
    }


}
