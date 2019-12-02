package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {

    @Test
    @DisplayName("사다리타기 결과 잘 매핑하나")
    void init() {
        Rewards rewards = new Rewards("a, b, c");
        User ike = new User("ike", 2);
        User hee = new User("hee", 0);
        User choi = new User("choi", 1);
        List<User> users = Arrays.asList(ike, hee, choi);
        rewards.init(users);

        assertThat(rewards.getResult("ike")).isEqualTo("c");
        assertThat(rewards.getResult("hee")).isEqualTo("a");
        assertThat(rewards.getResult("choi")).isEqualTo("b");
    }
}