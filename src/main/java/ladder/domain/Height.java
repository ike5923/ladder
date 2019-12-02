package ladder.domain;

import ladder.domain.exception.HeightException;
import org.apache.commons.lang3.math.NumberUtils;

public class Height {

    private static final int MIN_HEIGHT = 1;

    private final int value;

    public Height(final String inputValue) {
        this.value = validate(inputValue);
    }

    private int validate(final String inputValue) {
        if (isNotNumber(inputValue)) {
            throw new HeightException("높이는 숫자로 입력하세요.");
        }

        int value = Integer.parseInt(inputValue);
        if (isLowerMinHeight(value)) {
            throw new HeightException("높이는 최소 1 이상입니다.");
        }

        return value;
    }

    private boolean isNotNumber(final String inputValue) {
        return !NumberUtils.isCreatable(inputValue);
    }

    private boolean isLowerMinHeight(final int value) {
        return value < MIN_HEIGHT;
    }

    public int getValue() {
        return value;
    }
}
