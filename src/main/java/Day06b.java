import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Day06b {
    private List<Fish> input = new ArrayList<>();

    public String calculate(String fileName, int simulationTimeInDays) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        input = Arrays.stream(scanner.nextLine().split(",")).map(age -> new Fish(Byte.valueOf(age))).collect(Collectors.toList());

        for (int day = 1; day <= simulationTimeInDays; day++) {
            long newFishes = 0;
            for (Fish fish : input) {
                if (fish.getAge() == 0) {
                    fish.setAge((byte) 6);
                    newFishes += fish.count;
                } else {
                    fish.setAge((byte) (fish.age - 1));
                }
            }
            input.add(new Fish(newFishes, (byte) 8));
            if (day % 20 == 0) {
                System.out.println("Day " + day + ": " + count());
            }
        }


        return count() + "";
    }

    private long count() {
        long count = 0;
        for (Fish fish : input) {
            count += fish.count;
        }
        return count;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Fish {
        private long count = 1;
        private byte age;

        public Fish(byte age) {
            this.age = age;
        }
    }

}
