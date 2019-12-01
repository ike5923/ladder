package ladder.domain;

import ladder.domain.exception.HeightException;

public class Height {

    private final int value;

    public Height(final int value) {
        this.value = validate(value);
    }

    private int validate(final int value) {
        if (isLowerMinHeight(value)) {
            throw new HeightException("높이는 최소 1 이상입니다.");
        }

        return value;
    }

    private boolean isLowerMinHeight(final int value) {
        return value < 1;
    }

    public int getValue() {
        return value;
    }
}
