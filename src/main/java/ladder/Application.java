package ladder;

import ladder.controller.LadderGame;
import ladder.controller.RandomValueGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(InputView.inputNames(), InputView.inputHeight(), new RandomValueGenerator());
        OutputView.printLadder(ladderGame);

        ladderGame.execute();
        OutputView.printAllResult(ladderGame);
    }
}
