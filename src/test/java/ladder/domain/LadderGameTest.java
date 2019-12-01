package ladder.domain;

import ladder.domain.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @Test
    @DisplayName("참가자 이름 파싱")
    void parseNames() {
        LadderGame ladderGame = new LadderGame("ike, heebong, choihz, ddu0422, pkch93", 5, () -> true);
        List<String> actual = ladderGame.getUserNames();
        List<String> expected = Arrays.asList("ike", "heebong", "choihz", "ddu0422", "pkch93");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름이 공백일 때")
    void IsBlankInputNames() {
        assertThatThrownBy(() -> new LadderGame("", 5, () -> true))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("이름이 null일 때")
    void IsNullInputNames() {
        assertThatThrownBy(() -> new LadderGame(null, 5, () -> true))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("파싱된 이름이 공백일 때")
    void isBlankParsedName() {
        assertThatThrownBy(() -> new LadderGame("ike, , heebong", 5, () -> true))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("파싱된 이름이 중복될 때")
    void hasDuplicatedName() {
        assertThatThrownBy(() -> new LadderGame("ike, ike", 5, () -> true))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("참가자가 2명 이상이 아닐 때")
    void isInsufficientNumberOfUsers() {
        assertThatThrownBy(() -> new LadderGame("ike", 5, () -> true))
                .isInstanceOf(UserException.class);
    }
}