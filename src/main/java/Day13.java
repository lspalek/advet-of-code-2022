import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;

public class Day13 {
    List<Point> input = new ArrayList<>();
    char[][] table;
    int maxY = 0;
    int maxX = 0;

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();
            if (current.contains(",")) {
                Point point = new Point(Integer.valueOf(current.split(",")[0]), Integer.valueOf(current.split(",")[1]));
                maxX = Math.max(maxX, point.x);
                maxY = Math.max(maxY, point.y);
                input.add(point);
            } else {
                break;
            }
        }
        maxX++;
        maxY++;
        table = new char[maxY][maxX];
        for (int i = 0; i < maxY; i++) {
            Arrays.fill(table[i], ' ');
        }

        for (Point point : input) {
            table[point.y][point.x] = '#';
        }

        while (scanner.hasNextLine()) {
            print();
            System.out.println("---------------------------");
            var current = scanner.nextLine();
            if (current.contains("fold along y=")) {
                foldy(Integer.valueOf(current.replace("fold along y=", "")));
            } else {
                foldx(Integer.valueOf(current.replace("fold along x=", "")));
            }
            print();
            System.out.println("---------------------------");
            return calculateNumbers()+"";
        }


        return 0 + "";
    }

    private int calculateNumbers() {
        var result = 0;

        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (table[i][j] == '#') result++;
            }

        }
        return result;
    }

    private void foldx(Integer foldX) {
        for (int i = 0; i < maxY; i++) {
            for (int j = 1; (j + foldX) < maxX; j++) {
                if (table[i][foldX + j] == '#') {
                    table[i][foldX + j] = ' ';
                    table[i][foldX - j] = '#';
                }
            }
        }
    }

    private void foldy(Integer foldY) {
        for (int i = 0; i < maxX; i++) {
            for (int j = 1; (j + foldY) < maxY; j++) {
                if (table[foldY + j][i] == '#') {
                    table[foldY + j][i] = ' ';
                    table[foldY - j][i] = '#';
                }
            }
        }
    }

    private void print() {
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }


    @AllArgsConstructor
    class Point {
        int x;
        int y;
    }

}
