package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("고정 값으로 사다리 생성")
    void createLine() {
        Line line = new Line(4, () -> true);
        List<Position> positions = line.getPositions();

        Position first = positions.get(0);
        Position leftMiddle = positions.get(1);
        Position rightMiddle = positions.get(2);
        Position last = positions.get(3);

        Position expectedFirst = Position.of(false, true);
        Position expectedLeftMiddle = Position.of(true, false);
        Position expectedRightMiddle = Position.of(false, true);
        Position expectedLast = Position.of(true, false);

        assertThat(first).isEqualTo(expectedFirst);
        assertThat(leftMiddle).isEqualTo(expectedLeftMiddle);
        assertThat(rightMiddle).isEqualTo(expectedRightMiddle);
        assertThat(last).isEqualTo(expectedLast);
    }
}