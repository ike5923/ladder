package ladder.domain;

import ladder.domain.exception.UserException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LadderGame {

    private final List<String> userNames;
    private final Ladder ladder;

    public LadderGame(final String names, final int height, ValueGenerator valueGenerator) {
        this.userNames = validate(parseNames(names));
        this.ladder = new Ladder(height, userNames.size(), valueGenerator);
    }

    private String[] parseNames(final String names) {
        if (StringUtils.isBlank(names)) {
            throw new UserException("참가자를 입력해주세요.");
        }

        return names.replaceAll(" ", "").trim().split(",");
    }

    private List<String> validate(final String[] parseNames) {
        if (hasBlankName(parseNames)) {
            throw new UserException("참가자 이름에 공백이나 null값이 들어갑니다.");
        }

        if (hasDuplicatedName(parseNames)) {
            throw new UserException("참가자 이름이 중복됩니다.");
        }

        if (isInsufficientNumberOfUsers(parseNames)) {
            throw new UserException("참가자 수는 최소 2명 이상입니다.");
        }

        return Arrays.asList(parseNames);
    }

    private boolean hasBlankName(final String[] names) {
        return Stream.of(names)
                .anyMatch(StringUtils::isBlank);
    }

    private boolean hasDuplicatedName(final String[] names) {
        long countOfUniqueName = Stream.of(names)
                .distinct()
                .count();

        return countOfUniqueName != names.length;
    }

    private boolean isInsufficientNumberOfUsers(final String[] names) {
        return names.length < 2;
    }

    public List<String> getUserNames() {
        return Collections.unmodifiableList(userNames);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
