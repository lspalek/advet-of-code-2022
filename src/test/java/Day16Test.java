import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day16Test {

    private Day16 program = new Day16();

    @Test
    public void shouldRunOnExample() {
        then(program.calculate("day16-example.txt")).isEqualTo("16");
    }

    @Test
    public void shouldRunOnExampl2() {
        then(program.getVersionSum("620080001611562C8802118E34")).isEqualTo("12");
    }

    @Test
    public void shouldRunOnExampl3() {
        then(program.getVersionSum("C0015000016115A2E0802F182340")).isEqualTo("23");
    }
    @Test
    public void shouldRunOnExampl4() {
        then(program.getVersionSum("A0016C880162017C3686B18A3D4780")).isEqualTo("31");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day16.txt")).isEqualTo("");
    }

    @Test
    public void shouldParseNumber() {
        Day16.Packet p = new Day16.Packet("110100101111111000101000");
        then(p.version).isEqualTo(6);
        then(p.type).isEqualTo(4);
        then(p.number).isEqualTo("011111100101");
    }

    @Test
    public void shouldParseOperationWithTotalSubpacketsLength() {
        Day16.Packet p = new Day16.Packet("00111000000000000110111101000101001010010001001000000000");
        then(p.version).isEqualTo(1);
        then(p.type).isEqualTo(6);
        then(p.subpacketsTotalLength).isEqualTo(27);
        then(p.subPacketes.size()).isEqualTo(2);
        then(p.subPacketes.get(0).type).isEqualTo(4);
        then(p.subPacketes.get(1).type).isEqualTo(4);
//        then(p.subPacketes.get(2).type).isEqualTo(4);
        then(Integer.valueOf(p.subPacketes.get(0).number,2)).isEqualTo(10);
        then(Integer.valueOf(p.subPacketes.get(1).number,2)).isEqualTo(20);
//        then(Integer.valueOf(p.subPacketes.get(2).number,2)).isEqualTo(3);
    }

    @Test
    public void shouldParseOperationWithSubPacketCount() {
        Day16.Packet p = new Day16.Packet("11101110000000001101010000001100100000100011000001100000");
        then(p.version).isEqualTo(7);
        then(p.type).isEqualTo(3);
        then(p.subpacketsTotalLength).isNull();
        then(p.subpacketsCount).isEqualTo(3);
        then(p.subPacketes.size()).isEqualTo(3);
        then(p.subPacketes.get(0).type).isEqualTo(4);
        then(p.subPacketes.get(1).type).isEqualTo(4);
        then(p.subPacketes.get(2).type).isEqualTo(4);
        then(Integer.valueOf(p.subPacketes.get(0).number,2)).isEqualTo(1);
        then(Integer.valueOf(p.subPacketes.get(1).number,2)).isEqualTo(2);
        then(Integer.valueOf(p.subPacketes.get(2).number,2)).isEqualTo(3);
    }

}