import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day08 {

    List<String> grid = new ArrayList<>();

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        while (scanner.hasNextLine()) {
            grid.add(scanner.nextLine());
        }


        int visible = grid.size() * 2 + grid.get(0).length() * 2 - 4; // edges

        for (int i = 1; i < (grid.size() -1);i++) {
            for (int j=1;j < (grid.get(0).length()-1); j++) {
                visible += isTreeVisible(i,j);
            }
        }

        return visible + "";
    }

    private int isTreeVisible(int i, int j) {
        int visible = 1;
        char treeToCheck = grid.get(i).charAt(j);
        for (int k = 0; k < i; k++) {
            if (grid.get(k).charAt(j) >= treeToCheck) {
                visible = 0;
                break;
            }
        }
        if (visible == 1) {
            return 1;
        }

        visible = 1;
        for (int k = 0; k < j; k++) {
            if (grid.get(i).charAt(k) >= treeToCheck) {
                visible = 0;
                break;
            }
        }
        if (visible == 1) {
            return 1;
        }

        visible = 1;
        for (int k = i+1; k < grid.size(); k++) {
            if (grid.get(k).charAt(j) >= treeToCheck) {
                visible = 0;
                break;
            }
        }
        if (visible == 1) {
            return 1;
        }

        visible = 1;
        for (int k = j+1; k < grid.get(0).length(); k++) {
            if (grid.get(i).charAt(k) >= treeToCheck) {
                visible = 0;
                break;
            }
        }
        if (visible == 1) {
            return 1;
        }

        return 0;
    }

}
