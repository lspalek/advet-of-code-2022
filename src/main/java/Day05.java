import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;

public class Day05 {
//    private List<Integer> input = new ArrayList<>();

    private int[][] see;
    List<Line> lines = new ArrayList<>();
    int maxX = 0;
    int maxY = 0;

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        while (scanner.hasNextLine()) {
            String[] twoPoints = scanner.nextLine().split("(?:,| -> )");
            if (twoPoints[0].equals(twoPoints[2]) || twoPoints[1].equals(twoPoints[3])) {
                Line line = new Line(twoPoints);
                lines.add(line);

                maxX = Math.max(maxX, line.leftTop.x);
                maxX = Math.max(maxX, line.rightBottom.x);

                maxY = Math.max(maxY, line.leftTop.y);
                maxY = Math.max(maxY, line.rightBottom.y);
            }
        }

        maxX++;
        maxY++;
        see = new int[maxY][maxX];

        for (Line line : lines) {
            addLine(line);
        }


        return findPointsWhereLinesCross() + "";
    }

    private int findPointsWhereLinesCross() {
        int result = 0;
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (see[i][j] > 1) result++;
            }
        }
        return result;
    }

    private void addLine(Line line) {
        for (int i = line.leftTop.y; i <= line.rightBottom.y; i++) {
            for (int j = line.leftTop.x; j <= line.rightBottom.x; j++) {
                see[i][j]++;
            }
        }
    }

    @AllArgsConstructor
    class Point {
        int x;
        int y;
    }

    class Line {
        Point leftTop;
        Point rightBottom;

        Line(String[] twoPoints) {
            leftTop = new Point(Integer.valueOf(twoPoints[0]), Integer.valueOf(twoPoints[1]));
            rightBottom = new Point(Integer.valueOf(twoPoints[2]), Integer.valueOf(twoPoints[3]));
            if (leftTop.x > rightBottom.x || (leftTop.x == rightBottom.x && leftTop.y > rightBottom.y)) {
                var tmp = leftTop;
                leftTop = rightBottom;
                rightBottom = tmp;
            }
        }
    }

}
