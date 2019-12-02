package ladder.domain;

import ladder.domain.exception.UserException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final String SPACE = " ";
    private static final String NON_SPACE = "";
    private static final String NAME_DELIMITER = ",";
    private static final int MIN_NUMBER_OF_USERS = 2;

    private final List<User> users;

    public Users(final String names) {
        this.users = initUsers(names);
    }

    private List<User> initUsers(final String names) {
        List<String> userNames = validate(parseNames(names));
        return userNames.stream()
                .map(name -> new User(name, userNames.indexOf(name)))
                .collect(Collectors.toList());
    }

    private List<String> parseNames(final String names) {
        if (StringUtils.isBlank(names)) {
            throw new UserException("참가자를 입력해주세요.");
        }

        return Arrays.asList(names.replaceAll(SPACE, NON_SPACE).trim().split(NAME_DELIMITER));
    }

    private List<String> validate(final List<String> parseNames) {
        if (hasDuplicatedName(parseNames)) {
            throw new UserException("참가자 이름이 중복됩니다.");
        }

        if (isInsufficientNumberOfUsers(parseNames)) {
            throw new UserException("참가자 수는 최소 2명 이상입니다.");
        }

        return parseNames;
    }

    private boolean hasDuplicatedName(final List<String> names) {
        long countOfUniqueName = names.stream()
                .distinct()
                .count();

        return countOfUniqueName != names.size();
    }

    private boolean isInsufficientNumberOfUsers(final List<String> names) {
        return names.size() < MIN_NUMBER_OF_USERS;
    }

    public int getCountOfUsers() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public List<String> getUserNames() {
        List<String> userNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());

        return Collections.unmodifiableList(userNames);
    }
}
