package ladder;

import ladder.controller.LadderGame;
import ladder.controller.RandomValueGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(InputView.inputNames(), InputView.inputHeight(), InputView.inputReward(), new RandomValueGenerator());
        OutputView.printLadder(ladderGame);

        ladderGame.execute();

        String question = InputView.inputResult();
        while (!"all".equals(question)) {
            OutputView.printResult(ladderGame, question);
            question = InputView.inputResult();
        }
        OutputView.printAllResult(ladderGame);
    }
}
