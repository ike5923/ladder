package ladder.view;

import ladder.controller.LadderGame;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Position;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    private static final String SPACE = " ";
    private static final String ROW_LINE = "-";
    private static final String COL_LINE = "|";
    private static final String NEXT_LINE = "\n";

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void printLadder(LadderGame ladderGame) {
        printUserNames(ladderGame.getUserNames());
        printLadderBody(ladderGame.getLadder());
        System.out.println(stringBuilder.toString());
    }

    private static void printUserNames(final List<String> userNames) {
        userNames.stream()
                .map(name -> String.format("%10s", name))
                .forEach(name -> stringBuilder.append(name));
        stringBuilder.append(NEXT_LINE);
    }

    private static void printLadderBody(final Ladder ladder) {
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(final Line line) {
        line.getPositions().forEach(OutputView::drawRow);
        stringBuilder.append(NEXT_LINE);
    }

    private static void drawRow(final Position position) {
        if (position.isLeft()) {
            drawConnectedLine();
        } else {
            drawUnConnectedLine();
        }
    }

    private static void drawUnConnectedLine() {
        drawLine(SPACE);
    }

    private static void drawConnectedLine() {
        drawLine(ROW_LINE);
    }

    private static void drawLine(String icon) {
        IntStream.rangeClosed(1, 9).forEach(i -> stringBuilder.append(icon));
        stringBuilder.append(COL_LINE);
    }
}
