package ladder.domain;

import ladder.domain.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {

    @Test
    @DisplayName("참가자 이름 파싱")
    void parseNames() {
        Users users = new Users("ike, hee, choi, ddu, pkch");
        List<String> actual = users.getUserNames();
        List<String> expected = Arrays.asList("ike", "hee", "choi", "ddu", "pkch");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름이 공백일 때")
    void IsBlankInputNames() {
        assertThatThrownBy(() -> new Users(""))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("이름이 null일 때")
    void IsNullInputNames() {
        assertThatThrownBy(() -> new Users(null))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("파싱된 이름이 공백일 때")
    void isBlankParsedName() {
        assertThatThrownBy(() -> new Users("ike, , hee"))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("파싱된 이름이 중복될 때")
    void hasDuplicatedName() {
        assertThatThrownBy(() -> new Users("ike, ike"))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("5자 초과하는 이름이 있는지")
    void hasOverMaxNameLength() {
        assertThatThrownBy(() -> new Users("ike, ikeike"))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("참가자가 2명 이상이 아닐 때")
    void isInsufficientNumberOfUsers() {
        assertThatThrownBy(() -> new Users("ike"))
                .isInstanceOf(UserException.class);
    }
}