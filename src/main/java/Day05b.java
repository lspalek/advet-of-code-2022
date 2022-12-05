import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;

public class Day05b {
//    private List<Integer> input = new ArrayList<>();

    private int[][] see;
    List<Line> lines = new ArrayList<>();
    int maxX = 0;
    int maxY = 0;

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        while (scanner.hasNextLine()) {
            String[] twoPoints = scanner.nextLine().split("(?:,| -> )");
            Line line = new Line(twoPoints);
            lines.add(line);

            findMaxXY(line);
        }

        maxX++;
        maxY++;
        see = new int[maxY][maxX];

        for (Line line : lines) {
            addLine(line);
        }

        return findPointsWhereLinesCross() + "";
    }

    private void findMaxXY(Line line) {
        maxX = Math.max(maxX, line.leftTop.x);
        maxX = Math.max(maxX, line.rightBottom.x);

        maxY = Math.max(maxY, line.leftTop.y);
        maxY = Math.max(maxY, line.rightBottom.y);
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
        if (line.leftTop.x == line.rightBottom.x) {
            for (int i = line.leftTop.y; i <= line.rightBottom.y; i++) {
                see[i][line.leftTop.x]++;
            }
        } else if (line.leftTop.y == line.rightBottom.y) {
            for (int j = line.leftTop.x; j <= line.rightBottom.x; j++) {
                see[line.leftTop.y][j]++;
            }
        } else {
            var increase = 0;
            if (line.leftTop.y < line.rightBottom.y) {
                increase = 1;
            } else {
                increase = -1;
            }
            for (int i = 0; i <= Math.abs(line.leftTop.y - line.rightBottom.y); i++) {
                see[line.leftTop.y+i*increase][line.leftTop.x+i]++;
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
                swapVariables();
            }
        }

        private void swapVariables() {
            var tmp = leftTop;
            leftTop = rightBottom;
            rightBottom = tmp;
        }
    }

}
