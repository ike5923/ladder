package ladder.domain;

import ladder.domain.exception.RewardException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardsTest {

    private Rewards rewards;

    @BeforeEach
    void setUp() {
        rewards = new Rewards("a, b, c", 3);
        User ike = new User("ike", 2);
        User hee = new User("hee", 0);
        User choi = new User("choi", 1);
        List<User> users = Arrays.asList(ike, hee, choi);
        rewards.init(users);
    }

    @Test
    @DisplayName("사다리타기 결과 잘 매핑하나")
    void init() {
        assertThat(rewards.getResult("ike")).isEqualTo("c");
        assertThat(rewards.getResult("hee")).isEqualTo("a");
        assertThat(rewards.getResult("choi")).isEqualTo("b");
    }

    @Test
    @DisplayName("조회하려는 결과가 없을 때")
    void emptyResult() {
        assertThatThrownBy(() -> rewards.getResult("ddu"))
                .isInstanceOf(RewardException.class);
    }

    @Test
    @DisplayName("참가자 수와 결과의 수가 다를 때")
    void differentNumberOfUsersAndRewards() {
        assertThatThrownBy(() -> new Rewards("a, b, c", 4))
                .isInstanceOf(RewardException.class);
    }
}