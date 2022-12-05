import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day16 {

    Map<Character, String> hexToBinary = new HashMap<>();
    int versionSum = 0;

    private void init() {
        hexToBinary.put('0', "0000");
        hexToBinary.put('1', "0001");
        hexToBinary.put('2', "0010");
        hexToBinary.put('3', "0011");
        hexToBinary.put('4', "0100");
        hexToBinary.put('5', "0101");
        hexToBinary.put('6', "0110");
        hexToBinary.put('7', "0111");
        hexToBinary.put('8', "1000");
        hexToBinary.put('9', "1001");
        hexToBinary.put('A', "1010");
        hexToBinary.put('B', "1011");
        hexToBinary.put('C', "1100");
        hexToBinary.put('D', "1101");
        hexToBinary.put('E', "1110");
        hexToBinary.put('F', "1111");
    }

    public String calculate(String fileName) {

        Scanner scanner = new Scanner(this.getClass().getResourceAsStream(fileName));
        String hexaInput = scanner.nextLine();
        return getVersionSum(hexaInput);
    }

    protected String getVersionSum(String hexaInput) {
        init();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hexaInput.length(); i++) {
            sb.append(hexToBinary.get(hexaInput.charAt(i)));
        }
        String binaryInput = sb.toString();
        System.out.println(binaryInput);

        Packet p = new Packet(binaryInput);

       count(p);

        return versionSum + "";
    }

    private void count(Packet p) {
        versionSum += p.version;
        for (Packet sp : p.subPacketes) {
            count(sp);
        }
    }

    static class Packet {
        String s;
        int version;
        int type;
        String number;
        Integer subpacketsTotalLength;
        Integer subpacketsCount;
        int subpacketsStart;
        List<Packet> subPacketes = new ArrayList<>();
        Integer length;
        String moreToProcess;

        Packet(String binaryInput) {
            version = Integer.valueOf(binaryInput.substring(0, 3), 2);
            type = Integer.valueOf(binaryInput.substring(3, 6), 2);

            System.out.println("version = " + version + " type = " + type);

            int start = 1;
            if (type == 4) {
                StringBuilder sb = new StringBuilder();
                do {
                    start += 5;
                    sb.append(binaryInput.substring(start + 1, start + 5));
                } while (binaryInput.charAt(start) == '1');
                length = start + 5;
                number = sb.toString();
            } else {

                if (binaryInput.charAt(6) == '0') {
                    subpacketsStart = 7 + 15;
                    subpacketsTotalLength = Integer.valueOf(binaryInput.substring(7, subpacketsStart), 2);
                    length = subpacketsStart + subpacketsTotalLength;
                    processSubPAcketsByTotalLength(binaryInput);
                } else {
                    subpacketsStart = 7 + 11;
                    subpacketsCount = Integer.valueOf(binaryInput.substring(7, subpacketsStart), 2);
                    processSubPacketsByCount(binaryInput);
                }
            }

        }

        private void processSubPAcketsByTotalLength(String binaryInput) {
            Packet subPacket;

            String toProcess = binaryInput.substring(subpacketsStart, subpacketsStart + subpacketsTotalLength);
            do {
                subPacket = new Packet(toProcess);
                toProcess = toProcess.substring(subPacket.length);
                subPacketes.add(subPacket);
            } while (subPacket != null && !toProcess.isEmpty());
        }

        private void processSubPacketsByCount(String binaryInput) {
            Packet subPacket;
            int processesSubpacketLength = 0;
            String toProcess = binaryInput.substring(subpacketsStart);
            int i = 0;
            do {
                subPacket = new Packet(toProcess);
                processesSubpacketLength += subPacket.length;
                toProcess = toProcess.substring(subPacket.length);
                subPacketes.add(subPacket);
                i++;
            } while (subPacket != null && !toProcess.isEmpty() && i < subpacketsCount);
            length = subpacketsStart + processesSubpacketLength;
        }
    }

}
