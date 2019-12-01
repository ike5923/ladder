package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("입력한 높이 만큼 사다리가 생성이 되는 지")
    void countOfLines() {
        Ladder ladder = new Ladder(5, 4, () -> true);
        List<Line> lines = ladder.getLines();
        assertThat(lines.size()).isEqualTo(5);
    }
}