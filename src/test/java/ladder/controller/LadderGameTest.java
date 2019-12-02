package ladder.controller;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    void execute() {
        LadderGame ladderGame = new LadderGame("ike, hee, choi, ddu", 3, "x, o, x, o", () -> true);
        ladderGame.execute();

        Map<String, String> results = ladderGame.getResults();
        assertThat(results.get("ike")).isEqualTo("o");
        assertThat(results.get("hee")).isEqualTo("x");
        assertThat(results.get("choi")).isEqualTo("o");
        assertThat(results.get("ddu")).isEqualTo("x");
    }
}