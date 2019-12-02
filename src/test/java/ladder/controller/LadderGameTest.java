package ladder.controller;

import ladder.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    void execute() {
        LadderGame ladderGame = new LadderGame("ike, hee, choi, ddu", 3, () -> true);
        OutputView.printLadder(ladderGame);
        ladderGame.execute();

        List<Integer> results = ladderGame.getUsersLineNumber();
        assertThat(results.get(0)).isEqualTo(1);
        assertThat(results.get(1)).isEqualTo(0);
        assertThat(results.get(2)).isEqualTo(3);
        assertThat(results.get(3)).isEqualTo(2);
    }
}