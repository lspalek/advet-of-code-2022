import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class Day09 {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        Set<Point> positions = new HashSet<>();

        Point head = new Point(0, 0);
        Point tail = new Point(0, 0);
        while (scanner.hasNextLine()) {
            var current = scanner.nextLine().split(" ");

            for (int i = 0; i < Integer.parseInt(current[1]); i++) {
                head.moveOne(current[0].charAt(0));
                tail.moveCloserTo(head);
                positions.add(tail.clone());
            }
        }
        return positions.size() + "";
    }

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    class Point {
        private int x;
        private int y;

        boolean areNeighbours(Point sendPoint) {
            if (Math.abs(x - sendPoint.getX()) > 1 ||
                    Math.abs(y - sendPoint.getY()) > 1) {
                return false;
            } else {
                return true;
            }

        }

        void moveCloserTo(Point head) {
            if (areNeighbours(head)) {
                return;
            }
            if (x == head.getX()) {
                if (head.getY() > y) {
                    y++;
                } else {
                    y--;
                }
                return;
            }

            if (y == head.getY()) {
                if (head.getX() > x) {
                    x++;
                } else {
                    x--;
                }
                return;
            }

            if (head.areNeighbours(new Point(x + 1, y + 1))) {
                x++;
                y++;
                return;
            }

            if (head.areNeighbours(new Point(x + 1, y - 1))) {
                x++;
                y--;
                return;
            }

            if (head.areNeighbours(new Point(x - 1, y + 1))) {
                x--;
                y++;
                return;
            }

            if (head.areNeighbours(new Point(x - 1, y - 1))) {
                x--;
                y--;
                return;
            }

        }

        void moveOne(char direction) {
            switch (direction) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y--;
                    break;
                case 'D':
                    y++;
                    break;
            }
        }

        protected Point clone() {
            return new Point(x, y);
        }
    }

}
