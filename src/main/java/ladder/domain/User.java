package ladder.domain;

import ladder.domain.exception.UserException;
import org.apache.commons.lang3.StringUtils;

public class User {

    private static final int MIN_NAME_LENGTH = 5;
    private final String name;
    private int lineNumber;

    public User(final String name, final int lineNumber) {
        this.name = validate(name);
        this.lineNumber = lineNumber;
    }

    private String validate(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new UserException("참가자 이름에 공백이나 null이 들어갑니다.");
        }

        if (name.length() > MIN_NAME_LENGTH) {
            throw new UserException("이름은 최대 5자 이내 입니다.");
        }

        return name;
    }

    public void updateLineNumber(int nextLineNumber) {
        lineNumber = nextLineNumber;
    }

    public String getName() {
        return name;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
