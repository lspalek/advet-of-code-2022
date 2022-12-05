import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Day01 {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        long sumOfCalories = 0;
        long maxCarriedCalories = 0;
        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();
            if (StringUtils.isBlank(current)) {
                if (maxCarriedCalories < sumOfCalories) {
                    maxCarriedCalories = sumOfCalories;
                }
                sumOfCalories = 0;
            } else {
                sumOfCalories += Long.parseLong(current);

            }
        }

        if (maxCarriedCalories < sumOfCalories) {
            maxCarriedCalories = sumOfCalories;
        }


        return maxCarriedCalories + "";
    }

}
