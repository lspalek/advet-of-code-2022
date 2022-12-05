import java.util.Scanner;

import lombok.Getter;

public class Day21 {
    class Player {
        int startPosition;
        int currentPosition;
        @Getter
        int score;


        public Player(int start) {
            startPosition = start;
            currentPosition = start;
            score = 0;
        }

        public void movePawn(int forwardCount) {
            int newPosition = currentPosition + (forwardCount % 10);
            if (newPosition > 10) {
                newPosition -= 10;
            }
            currentPosition = newPosition;
            score += newPosition;
        }
    }

    int dieRollCount = 0;
    Player p1;
    Player p2;

    int nextRoll = 1;


    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        var current = scanner.nextLine();
        p1 = new Player(Integer.valueOf(current.substring(28)));

        current = scanner.nextLine();
        p2 = new Player(Integer.valueOf(current.substring(28)));

        while (true) {
            p1.movePawn(roll() + roll() + roll());
            if (p1.getScore() >= 1000) {
                return (long) p2.score * dieRollCount + "";
            }
            p2.movePawn(roll() + roll() + roll());
            if (p2.getScore() >= 1000) {
                return (long) p1.score * dieRollCount + "";
            }
        }
    }


    private int roll() {
        dieRollCount++;
        var result = nextRoll;
        if (nextRoll < 100) {
            nextRoll++;
        } else {
            nextRoll = 1;
        }
        return result;
    }

}
