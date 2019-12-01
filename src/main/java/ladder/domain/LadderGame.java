package ladder.domain;

public class LadderGame {

    private final Users users;
    private final Ladder ladder;

    public LadderGame(final String names, final int height, ValueGenerator valueGenerator) {
        this.users = new Users(names);
        this.ladder = new Ladder(new Height(height), users.getCountOfUsers(), valueGenerator);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
