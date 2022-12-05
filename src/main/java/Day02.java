import java.util.Scanner;

public class Day02 {

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        long round = 0;
        long myPoints = 0;
        long oponentsPoints = 0;
        while (scanner.hasNextLine()) {
            round++;
            var roundStrategy = scanner.nextLine().split(" ");
            long oponentsChoice = ((int) roundStrategy[0].charAt(0)) - ((int) 'A') + 1;
            long myChoice = ((int) roundStrategy[1].charAt(0)) - ((int) 'X') + 1;
            // A = 1 = rock
            // B = 2 = paper
            // C = 3 = scissors

            // X = 1 =  rock
            // Y = 2 = paper
            // Z = 3 = scissors
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

}
