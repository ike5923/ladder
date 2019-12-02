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
    @DisplayName("입력받은 참가자가 공백일 때")
    void IsBlankInputNames() {
        assertThatThrownBy(() -> new Users(""))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("입력받은 참가자가 null일 때")
    void IsNullInputNames() {
        assertThatThrownBy(() -> new Users(null))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("이름이 중복될 때")
    void hasDuplicatedName() {
        assertThatThrownBy(() -> new Users("ike, ike"))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("참가자가 2명 이상이 아닐 때")
    void isInsufficientNumberOfUsers() {
        assertThatThrownBy(() -> new Users("ike"))
                .isInstanceOf(UserException.class);
    }

    @Test
    @DisplayName("참가자 초기화 잘 되는지")
    void initUsers() {
        List<User> users = new Users("ike, hee, choi").getUsers();
        User ike = users.get(0);
        User hee = users.get(1);
        User choi = users.get(2);

        assertThat(ike.getLineNumber()).isEqualTo(0);
        assertThat(hee.getLineNumber()).isEqualTo(1);
        assertThat(choi.getLineNumber()).isEqualTo(2);
    }
}