package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("참가자 이름 파싱")
    void parseNames() {
        LadderGame ladderGame = new LadderGame("ike, heebong, choihz, ddu0422, pkch93", 5, () -> true);
        List<String> actual = ladderGame.getUserNames();
        List<String> expected = Arrays.asList("ike", "heebong", "choihz", "ddu0422", "pkch93");

        assertThat(actual).isEqualTo(expected);
    }
}