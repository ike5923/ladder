package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LadderGame {

    private final List<String> userNames;
    private final Ladder ladder;

    public LadderGame(final String names, final int height, ValueGenerator valueGenerator) {
        this.userNames = initNames(names);
        this.ladder = new Ladder(height, userNames.size(), valueGenerator);
    }

    private List<String> initNames(final String names) {
        return Arrays.asList(names.replaceAll(" ", "").trim().split(","));
    }

    public List<String> getUserNames() {
        return Collections.unmodifiableList(userNames);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
