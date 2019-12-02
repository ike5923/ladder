package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Users users;
    private final Ladder ladder;

    public LadderGame(final String names, final int height, ValueGenerator valueGenerator) {
        this.users = new Users(names);
        this.ladder = new Ladder(new Height(height), users.getCountOfUsers(), valueGenerator);
    }

    public void execute() {
        users.getUsers().forEach(ladder::move);
    }

    public List<String> getUserNames() {
        return Collections.unmodifiableList(users.getUserNames());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Integer> getUsersLineNumber() {
        return users.getUsers().stream()
                .map(User::getLineNumber)
                .collect(Collectors.toList());
    }
}
