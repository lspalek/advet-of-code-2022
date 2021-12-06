import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Day04b {
    private List<Integer> drawnList = new ArrayList<>();
    private List<BingoTicket> tickets = new ArrayList<>();
    private Set<Integer> stillNotWining = new HashSet<>();


    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        drawnList = Arrays.stream(scanner.nextLine().split(","))
                .map(s -> Integer.valueOf(s))
                .collect(Collectors.toList());
        do {
            BingoTicket ticket = new BingoTicket();
            for (int i = 0; i < 25; i++) {
                ticket.add(scanner.nextInt());
            }
            tickets.add(ticket);
            stillNotWining.add(tickets.size() - 1);
        } while (scanner.hasNextInt());

        // game
        Integer winingTicketIndex = null;
        for (int drawnNumber : drawnList) {
            for (int i = 0; i < tickets.size(); i++) {
                BingoTicket bt = tickets.get(i);
                bt.drawn(drawnNumber);
                if (bt.isWinning()) {
                    if(stillNotWining.contains(i) && stillNotWining.size() == 1) {
//                        last wining ticket
                        System.out.println("Hello Last Bingo winning ticket " + i + " is wiining");
                        return (bt.calculateScore(drawnNumber)) + "";
                    }
                    if (stillNotWining.contains(i)) {
                        System.out.println("Hello ticket " + i + " is wiining");
                    }
                    stillNotWining.remove(i);

                }
            }

        }

        return "";
    }

    class BingoTicket {
        private int ticket[][] = new int[5][5];
        private boolean checked[][] = new boolean[5][5];
        private int addedCount = 0;
        private boolean winning = false;

        public boolean isWinning() {
            return winning;
        }

        public void add(int number) {
            if (addedCount > 24) {
                throw new RuntimeException("The bingo ticket is already full");
            }
            ticket[addedCount / 5][addedCount % 5] = number;
            addedCount++;
        }

        public void drawn(int number) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (ticket[i][j] == number) {
                        checked[i][j] = true;
                        if (!winning && (checkRow(i) || checkColumn(j))) {
                            winning = true;
                        }
                        return;
                    }
                }
            }
        }

        public boolean winning() {

            for (int i = 0; i < 5; i++) {
                if (checkColumn(i) || checkRow(i)) return true;
            }

            return false;
        }

        public boolean checkRow(int index) {
            for (int i = 0; i < 5; i++) {
                if (!checked[index][i]) return false;
            }
            return true;
        }

        public boolean checkColumn(int index) {
            for (int i = 0; i < 5; i++) {
                if (!checked[i][index]) return false;
            }
            return true;
        }

        public int calculateScore(int lastCalledNumer) {

            int sumOfUncheckedNumbers = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (!checked[i][j]) {
                        sumOfUncheckedNumbers += ticket[i][j];
                    }
                }
            }
            return sumOfUncheckedNumbers * lastCalledNumer;
        }
    }
}
