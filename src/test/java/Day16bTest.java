import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class Day16bTest {

    private Day16b program = new Day16b();

    @Test
    public void shouldRunOnExampl2() {
        then(program.calculateValue("04005AC33890")).isEqualTo("54");
    }

    @Test
    public void shouldRunOnExampl3() {
        then(program.calculateValue("880086C3E88112")).isEqualTo("7");
    }

    @Test
    public void shouldRunOnExampl4() {
        then(program.calculateValue("CE00C43D881120")).isEqualTo("9");
    }

    @Test
    public void shouldRunOnExampl5() {
        then(program.calculateValue("D8005AC2A8F0")).isEqualTo("1");
    }

    @Test
    public void shouldRunOnExampl6() {
        then(program.calculateValue("F600BC2D8F")).isEqualTo("0");
    }

    @Test
    public void shouldRunOnExampl7() {
        then(program.calculateValue("9C005AC2F8F0")).isEqualTo("0");
    }

    @Test
    public void shouldRunOnExampl8() {
        then(program.calculateValue("9C0141080250320F1802104A08")).isEqualTo("1");
    }

    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day16b.txt")).isEqualTo("");
    }

    @Test
    public void shouldParseNumber() {
        Day16b.Packet p = new Day16b.Packet("110100101111111000101000");
        then(p.version).isEqualTo(6);
        then(p.type).isEqualTo(4);
        then(p.number).isEqualTo("011111100101");
    }

    @Test
    public void shouldParseOperationWithTotalSubpacketsLength() {
        Day16b.Packet p = new Day16b.Packet("00111000000000000110111101000101001010010001001000000000");
        then(p.version).isEqualTo(1);
        then(p.type).isEqualTo(6);
        then(p.subpacketsTotalLength).isEqualTo(27);
        then(p.subPacketes.size()).isEqualTo(2);
        then(p.subPacketes.get(0).type).isEqualTo(4);
        then(p.subPacketes.get(1).type).isEqualTo(4);
//        then(p.subPacketes.get(2).type).isEqualTo(4);
        then(Long.valueOf(p.subPacketes.get(0).number, 2)).isEqualTo(10);
        then(Long.valueOf(p.subPacketes.get(1).number, 2)).isEqualTo(20);
//        then(Long.valueOf(p.subPacketes.get(2).number,2)).isEqualTo(3);
    }

    @Test
    public void shouldParseOperationWithSubPacketCount() {
        Day16b.Packet p = new Day16b.Packet("11101110000000001101010000001100100000100011000001100000");
        then(p.version).isEqualTo(7);
        then(p.type).isEqualTo(3);
        then(p.subpacketsTotalLength).isNull();
        then(p.subpacketsCount).isEqualTo(3);
        then(p.subPacketes.size()).isEqualTo(3);
        then(p.subPacketes.get(0).type).isEqualTo(4);
        then(p.subPacketes.get(1).type).isEqualTo(4);
        then(p.subPacketes.get(2).type).isEqualTo(4);
        then(Long.valueOf(p.subPacketes.get(0).number, 2)).isEqualTo(1);
        then(Long.valueOf(p.subPacketes.get(1).number, 2)).isEqualTo(2);
        then(Long.valueOf(p.subPacketes.get(2).number, 2)).isEqualTo(3);
    }

}