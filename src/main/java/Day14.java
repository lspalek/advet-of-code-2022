import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;

public class Day14 {


    private String start;
    private MultiKeyMap mapping = new MultiKeyMap();
    private MultiKeyMap neighbours = new MultiKeyMap();
    private MultiKeyMap newNeighbours = new MultiKeyMap();
    private Map<Character, Long> letterCount = new HashMap<>();
    private int steps = 2;

    public String calculate(String fileName, int steps) {

        calculateLetterCount(fileName, steps);
        letterCount.merge(start.charAt(0), 1l, Long::sum);
        letterCount.merge(start.charAt(start.length() - 1), 1l, Long::sum);
        letterCount.merge(start.charAt(start.length() - 1), 1l, Long::sum);
        Long min = Long.MAX_VALUE;
        Long max = 0l;

        for (Long count : letterCount.values()) {
            min = min < count ? min : count;
            max = max > count ? max : count;
        }

        System.out.println("Min " + min / 2 + " max = " + max / 2);

        return (max / 2) - (min / 2) + "";
    }

    protected Map<Character, Long> calculateLetterCount(String fileName, int steps) {
        calculateNeigbours(fileName, steps);

        for (Object entry : neighbours.entrySet()) {
            Map.Entry<MultiKey<Character>, Long> entry1 = (Map.Entry<MultiKey<Character>, Long>) entry;
            Long currentLetterPairCount = entry1.getValue();

            letterCount.merge(entry1.getKey().getKey(0), currentLetterPairCount, Long::sum);
            letterCount.merge(entry1.getKey().getKey(1), currentLetterPairCount, Long::sum);

        }
        return letterCount;
    }

    protected MultiKeyMap calculateNeigbours(String fileName, int steps) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        start = scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();
            mapping.put(line.charAt(0), line.charAt(1), line.charAt(6));
//            System.out.println(line.charAt(0) + " " + line.charAt(1) + " " + line.charAt(6));
        }

        for (int i = 0; i < start.length() - 1; i++) {
            Optional<Long> aaa = Optional.ofNullable((Long) neighbours.get(start.charAt(i), start.charAt(i + 1)));
            neighbours.put(start.charAt(i), start.charAt(i + 1), aaa.orElse(1l));
        }

        for (int i = 0; i < steps; i++) {
            for (Object key : neighbours.keySet()) {
                MultiKey<Character> mkey = (MultiKey<Character>) key;
                Character letterToInsert = (Character) mapping.get(mkey);
                Long currentLetterPairCount = (Long) neighbours.get(mkey);
                if (letterToInsert == null) {
                    newNeighbours.put(mkey.getKey(0), mkey.getKey(1), currentLetterPairCount);
                } else {
                    Long count = (Long) newNeighbours.get(mkey.getKey(0), letterToInsert);
                    count = count == null ? currentLetterPairCount : count + currentLetterPairCount;
                    newNeighbours.put(mkey.getKey(0), letterToInsert, count);

                    count = (Long) newNeighbours.get(letterToInsert, mkey.getKey(1));
                    count = count == null ? currentLetterPairCount : count + currentLetterPairCount;
                    newNeighbours.put(letterToInsert, mkey.getKey(1), count);
                }
            }
            neighbours = newNeighbours;
            newNeighbours = new MultiKeyMap();
        }
        return neighbours;
    }
}
