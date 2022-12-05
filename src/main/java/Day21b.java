import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Day21b {
    long wins1 = 0;
    long wins2 = 0;

    long round = 0;

    Player p1;
    Player p2;


    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));

        var current = scanner.nextLine();
        p1 = new Player(Long.valueOf(current.substring(28)));

        current = scanner.nextLine();
        p2 = new Player(Long.valueOf(current.substring(28)));

        recursion(p1, p2, 1);

        return Math.max(wins1, wins2) + "";
    }

    private void recursion(Player p1, Player p2, long nexTurn) {
        System.out.println("Universe " + ++round);
        if (nexTurn == 1) {
            Player newP1 = p1.clone();
            newP1.movePawn(1);
            if (p1.getScore() >= 21) {
                wins1++;
                return;
            } else {
                recursion(newP1, p2, 2);
            }
            newP1.movePawn(1);
            if (p1.getScore() >= 21) {
                wins1++;
                return;
            } else {
                recursion(newP1, p2, 2);
            }
            newP1.movePawn(1);
            if (p1.getScore() >= 21) {
                wins1++;
                return;
            } else {
                recursion(newP1, p2, 2);
            }


        } else {
            Player newP2 = p2.clone();
            newP2.movePawn(1);
            if (p2.getScore() >= 21) {
                wins1++;
                return;
            } else {
                recursion(p2, newP2, 1);
            }
            newP2.movePawn(1);
            if (p2.getScore() >= 21) {
                wins1++;
                return;
            } else {
                recursion(p2, newP2, 1);
            }
            newP2.movePawn(1);
            if (p2.getScore() >= 21) {
                wins1++;
                return;
            } else {
                recursion(p2, newP2, 1);
            }
        }
    }

    @AllArgsConstructor
    class Player {
        long startPosition;
        long currentPosition;
        @Getter
        long score;


        public Player(long start) {
            startPosition = start;
            currentPosition = start;
            score = 0;
        }

        public void movePawn(long forwardCount) {
            long newPosition = currentPosition + forwardCount;
            if (newPosition > 10) {
                newPosition -= 10;
            }
            currentPosition = newPosition;
            score += newPosition;
        }

        public Player clone() {
            return new Player(startPosition, currentPosition, score);
        }
    }

}
