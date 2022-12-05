import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Day01b {
    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        long sumOfCalories = 0;
        List<Long> elfsCalories = new ArrayList<>();

        while (scanner.hasNextLine()) {
            var current = scanner.nextLine();
            if (StringUtils.isBlank(current)) {
                elfsCalories.add(sumOfCalories);
                sumOfCalories = 0;
            } else {
                sumOfCalories += Long.parseLong(current);
            }
        }
        elfsCalories.add(sumOfCalories);

        long result = elfsCalories.stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .reduce(0l, (a, b) -> a + b);


        return result + "";
    }

}
