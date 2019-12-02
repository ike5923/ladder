package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Rewards;
import ladder.domain.Users;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Users users;
    private final Ladder ladder;
    private final Rewards rewards;

    public LadderGame(final String names, final String height, final String rewards, ValueGenerator valueGenerator) {
        this.users = new Users(names);
        this.ladder = new Ladder(new Height(height), users.getCountOfUsers(), valueGenerator);
        this.rewards = new Rewards(rewards, users.getCountOfUsers());
    }

    public void execute() {
        users.getUsers().forEach(ladder::move);
        rewards.init(users.getUsers());
    }

    public List<String> getUserNames() {
        return Collections.unmodifiableList(users.getUserNames());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Map<String, String> getResults() {
        return rewards.getResults();
    }

    public String getResult(final String question) {
        return rewards.getResult(question);
    }
}
