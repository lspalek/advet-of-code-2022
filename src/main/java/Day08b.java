import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day08b {

    List<String> grid = new ArrayList<>();

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        while (scanner.hasNextLine()) {
            grid.add(scanner.nextLine());
        }

        int maxScenincView = 0;

        for (int i = 1; i < (grid.size() -1);i++) {
            for (int j=1;j < (grid.get(0).length()-1); j++) {
                maxScenincView = Math.max(maxScenincView, calculateScenicView(i, j));
            }
        }

        return maxScenincView + "";
    }

    private int calculateScenicView(int i, int j) {
        int scenicView = 0;

        char currentTree = grid.get(i).charAt(j);

        int visibleCount = 0;
        for (int k = i-1; k >=0; k--) {
            visibleCount++;
            if (grid.get(k).charAt(j) >= currentTree) {
                break;
            }
        }
        scenicView = visibleCount;

        visibleCount = 0;
        for (int k = i+1; k < grid.size(); k++) {
            visibleCount++;
            if (grid.get(k).charAt(j) >= currentTree) {
                break;
            }
        }
        scenicView = scenicView * visibleCount;

        visibleCount = 0;
        for (int k = j-1; k >=0; k--) {
                visibleCount++;
            if (grid.get(i).charAt(k) >= currentTree) {
                break;
            }
        }
        scenicView = scenicView * visibleCount;

        visibleCount = 0;
        for (int k = j+1; k < grid.size(); k++) {
            visibleCount++;
            if (grid.get(i).charAt(k) >= currentTree) {
                break;
            }
        }
        scenicView = scenicView * visibleCount;

        return scenicView;
    }

}
