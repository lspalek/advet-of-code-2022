import java.util.Scanner;

public class Day03 {
    private int[] oneCount;
    private int[] zeroCount;

    public String calculate(String fileName) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        String s = scanner.next();
        oneCount = new int[s.length()];
        zeroCount = new int[s.length()];
        do {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeroCount[i]++;
                else oneCount[i]++;
            }
            s = scanner.next();
        } while (scanner.hasNextLine());


        String gammaRate = "";
        String epsilonRate = "";

        for (int i = 0; i < s.length(); i++) {
            if (zeroCount[i] < oneCount[i]) {
                gammaRate = gammaRate + "1";
                epsilonRate = epsilonRate + "0";
            } else {
                gammaRate = gammaRate + "0";
                epsilonRate = epsilonRate + "1";
            }
        }
        var gama = Integer.parseInt(gammaRate, 2);
        var eps = Integer.parseInt(epsilonRate, 2);
        return gama * eps + "";
    }

}
