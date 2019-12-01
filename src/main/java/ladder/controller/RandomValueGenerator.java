package ladder.controller;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
