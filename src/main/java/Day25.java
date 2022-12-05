import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day25 {
    List<char[]> input = new ArrayList<>();
    char[][] seafloor;
    int height;
    int width;

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine().toCharArray());
        }

        seafloor = input.toArray(new char[1][1]);
        height = seafloor.length;
        width = seafloor[0].length;

        int step = 1;
        while (isMooving()) {
            System.out.println(step);
            step++;
        }

        return step + "";
    }

    private boolean isMooving() {
        return moveRight() | moveDown();
    }

    private boolean moveRight() {
        boolean anyMove = false;
        char[][] newSea = createEmptySea();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (seafloor[i][j] == '>') {
                    if (seafloor[i][(j + 1) % width] == '.') {
                        newSea[i][(j + 1) % width] = '>';
                        anyMove = true;
                    } else {
                        newSea[i][j] = seafloor[i][j];
                    }
                } else  if (seafloor[i][j] == 'v') {
                    newSea[i][j] = seafloor[i][j];
                }
            }
        }
        seafloor = newSea;
        return anyMove;
    }

    private boolean moveDown() {
        boolean anyMove = false;
        char[][] newSea = createEmptySea();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (seafloor[i][j] == 'v') {
                    if (seafloor[(i + 1) % height][j] == '.') {
                        newSea[(i + 1) % height][j] = 'v';
                        anyMove = true;
                    } else {
                        newSea[i][j] = seafloor[i][j];
                    }
                } else if (seafloor[i][j] == '>') {
                    newSea[i][j] = seafloor[i][j];
                }
            }
        }
        seafloor = newSea;
        return anyMove;
    }


    private char[][] createEmptySea() {
        char[][] newSea = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(newSea[i], '.');
        }
        return newSea;
    }

}
