import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Day04b {
    private List<Range> ranges = new ArrayList<>();


    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        long count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] a = line.split(",");
            var r1 = new Range(a[0]);
            var r2 = new Range(a[1]);

            if (r1.overlap(r2) || r2.overlap(r1)) {
                count++;
            }
        }
        return count + "";
    }

    @Data
    @AllArgsConstructor
    class Range {
        private int start;
        private int end;

        public Range(String s) {
            String[] arrayOf2Numbers = s.split("-");
            start = Integer.parseInt(arrayOf2Numbers[0]);
            end = Integer.parseInt(arrayOf2Numbers[1]);
        }

        public boolean contains(Range r2) {
            if (start <= r2.getStart() && end >= r2.end) {
                return true;
            }
            return false;

        }

        public boolean overlap(Range r2) {
            if (start <= r2.getEnd() && end >= r2.getStart()) {
                return true;
            }
            return false;

        }

    }
}
