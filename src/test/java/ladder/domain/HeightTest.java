package ladder.domain;

import ladder.domain.exception.HeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    @DisplayName("입력한 높이가 최소 높이보다 작을 때")
    void isLowerMinHeight() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(HeightException.class);
    }
}