import java.util.Scanner;

public class Day02b {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        long round = 0;
        long myPoints = 0;
        long oponentsPoints = 0;
        while (scanner.hasNextLine()) {
            round++;
            var roundStrategy = scanner.nextLine().split(" ");
            int oponentsChoice = ((int) roundStrategy[0].charAt(0)) - ((int) 'A') + 1;
            long result = ((int) roundStrategy[1].charAt(0)) - ((int) 'X') + 1;

            int myChoice = calculateMyChoice(oponentsChoice, result);

            if ((oponentsChoice == 1 && myChoice == 2) ||
                    (oponentsChoice == 2 && myChoice == 3) ||
                    (oponentsChoice == 3 && myChoice == 1)) {

                myPoints += myChoice + 6;
                oponentsPoints += oponentsChoice;
            } else if (oponentsChoice == myChoice) {
                myPoints += myChoice + 3;
                oponentsPoints += oponentsChoice + 3;
            } else {
                myPoints += myChoice;
                oponentsPoints += oponentsChoice + 6;
            }
        }
        return myPoints + "";
    }

    // A = 1 = rock
    // B = 2 = paper
    // C = 3 = scissors

    // X = 1 = ose
    // Y = 2 = draw
    // Z = 3 = win
    private int calculateMyChoice(int oponentsChoice, long result) {
        if (result == 2) {
            return oponentsChoice;
        }
        switch (oponentsChoice) {
            case 1:
                if (result == 1) {
                    return 3;
                } else {
                    return 2;
                }
            case 2:
                if (result == 1) {
                    return 1;
                } else {
                    return 3;
                }
            case 3:
                if (result == 1) {
                    return 2;
                } else {
                    return 1;
                }
        }
        throw new RuntimeException();
    }

}
