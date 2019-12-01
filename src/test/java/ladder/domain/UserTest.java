package ladder.domain;

import ladder.domain.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @Test
    @DisplayName("이름이 null일 때")
    void isNullName() {
        assertThatThrownBy(() -> new User(null, 1))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("이름이 공백일 때")
    void isBlankName() {
        assertThatThrownBy(() -> new User("", 1))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("이름이 5자를 초과하는지")
    void hasOverMaxNameLength() {
        assertThatThrownBy(() -> new User("ikeike", 1))
                .isInstanceOf(UserException.class);
    }
}