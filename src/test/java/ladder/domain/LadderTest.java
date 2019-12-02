package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new Height(2), 3, () -> true);
    }

    @Test
    @DisplayName("입력한 높이 만큼 사다리가 생성이 되는 지")
    void countOfLines() {
        List<Line> lines = ladder.getLines();
        assertThat(lines.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리타기 결과 확인")
    void move() {
        User user = new User("ike", 1);
        ladder.move(user);
        assertThat(user.getLineNumber()).isEqualTo(1);
    }
}