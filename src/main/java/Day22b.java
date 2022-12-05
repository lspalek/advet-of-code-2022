import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.ToString;

public class Day22b {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();
            Cuboid c = new Cuboid(current);
            if (current.startsWith("on")) {
                turnOn(c);
            } else if (current.startsWith("off")) {
                turnOff(c);
            }
        }
        return count() + "";
    }

    boolean[][][] space = new boolean[101][101][101];

    public int count() {
        int onCount = 0;
        for (int i = -50; i <= 50; i++) {
            for (int j = -50; j <= 50; j++) {
                for (int k = -50; k <= 50; k++) {
                    if (space[i + 50][j + 50][k + 50]) {
                        onCount++;
                    }
                }
            }
        }
        return onCount;
    }

    public void turnOn(Cuboid c) {
        for (int i = Math.max(-50, c.x[0]); i <= Math.min(50, c.x[1]); i++) {
            for (int j = Math.max(-50, c.y[0]); j <= Math.min(50, c.y[1]); j++) {
                for (int k = Math.max(-50, c.z[0]); k <= Math.min(50, c.z[1]); k++) {
                    space[i + 50][j + 50][k + 50] = true;
                }
            }
        }
    }

    public void turnOff(Cuboid c) {
        for (int i = Math.max(-50, c.x[0]); i <= Math.min(50, c.x[1]); i++) {
            for (int j = Math.max(-50, c.y[0]); j <= Math.min(50, c.y[1]); j++) {
                for (int k = Math.max(-50, c.z[0]); k <= Math.min(50, c.z[1]); k++) {
                    space[i + 50][j + 50][k + 50] = false;
                }
            }
        }
    }


    @ToString
    class Cuboid {
        int[] x = new int[2];
        int[] y = new int[2];
        int[] z = new int[2];

        public Cuboid(String s) {
            Pattern p = Pattern.compile("(-?\\d+)\\.\\.(-?\\d+)");
            Matcher m = p.matcher(s);

            m.find();
            x[0] = Integer.valueOf(m.group(1));
            x[1] = Integer.valueOf(m.group(2));

            m.find();
            y[0] = Integer.valueOf(m.group(1));
            y[1] = Integer.valueOf(m.group(2));

            m.find();
            z[0] = Integer.valueOf(m.group(1));
            z[1] = Integer.valueOf(m.group(2));

            System.out.println(this);
        }
    }
}
