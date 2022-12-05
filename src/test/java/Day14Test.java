import static org.assertj.core.api.BDDAssertions.then;

import java.util.Map;

import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;

public class Day14Test {

    private Day14 program = new Day14();

    @Test
    public void shouldRunOnExampleStep1() {
        then(program.calculate("day14-example.txt", 1)).isEqualTo("1");
    }
    @Test
    public void shouldRunOnExampleStep2() {
        then(program.calculate("day14-example.txt", 2)).isEqualTo("5");
    }
    @Test
    public void shouldRunOnExampleStep3() {
        then(program.calculate("day14-example.txt", 3)).isEqualTo("7");
    }
    @Test
    public void shouldRunOnExampleStep4() {
        then(program.calculate("day14-example.txt", 4)).isEqualTo("18");
    }
    @Test
    public void shouldRunOnExampleStep10() {
        then(program.calculate("day14-example.txt", 10)).isEqualTo("1588");
    }
    @Test
    public void shouldRunOnExampleStep40() {
        then(program.calculate("day14-example.txt", 40)).isEqualTo("2188189693529");
    }
    @Test
    public void shouldCalculateLetters() {
        Map<Character, Long> characterLongMap = program.calculateLetterCount("day14-example.txt", 1);
        then(characterLongMap.get('N')).isEqualTo(2l);
        then(characterLongMap.get('C')).isEqualTo(2l);
        then(characterLongMap.get('B')).isEqualTo(2l);
        then(characterLongMap.get('H')).isEqualTo(1l);
    }

    @Test
    public void shouldCalculateNeighbours() {
        MultiKeyMap map = program.calculateNeigbours("day14-example.txt", 1);
        then(map.size()).isEqualTo(6);
        then(map.get('N','C')).isEqualTo(1l);
        then(map.get('C','N')).isEqualTo(1l);
        then(map.get('N','B')).isEqualTo(1l);
        then(map.get('B','C')).isEqualTo(1l);
        then(map.get('C','H')).isEqualTo(1l);
        then(map.get('H','B')).isEqualTo(1l);
    }


    @Test
    public void shouldCalculateNeighbours2() {
        MultiKeyMap map = program.calculateNeigbours("day14-example.txt", 2);
        then(map.size()).isEqualTo(8);
        then(map.get('N','B')).isEqualTo(2l);
        then(map.get('B','C')).isEqualTo(2l);
        then(map.get('C','C')).isEqualTo(1l);
        then(map.get('C','N')).isEqualTo(1l);
        then(map.get('B','B')).isEqualTo(2l);
        then(map.get('C','B')).isEqualTo(2l);
        then(map.get('B','H')).isEqualTo(1l);
        then(map.get('H','C')).isEqualTo(1l);
    }
    @Test
    public void shouldRunOn1Sample() {
        then(program.calculate("day14.txt", 10)).isEqualTo("");
    }

    @Test
    public void shouldRunOn1Sample40() {
        then(program.calculate("day14.txt", 40)).isEqualTo("");
    }
}
//NBCCNBBBCBHCB