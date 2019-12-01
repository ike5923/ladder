package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Users;

import java.util.Collections;
import java.util.List;

public class LadderGame {

    private final Users users;
    private final Ladder ladder;

    public LadderGame(final String names, final int height, ValueGenerator valueGenerator) {
        this.users = new Users(names);
        this.ladder = new Ladder(new Height(height), users.getCountOfUsers(), valueGenerator);
    }

    public List<String> getUserNames() {
        return Collections.unmodifiableList(users.getUserNames());
    }

    public Ladder getLadder() {
        return ladder;
    }
}
