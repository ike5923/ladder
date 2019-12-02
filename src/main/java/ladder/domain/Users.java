package ladder.domain;

import ladder.domain.exception.UserException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {

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

    private String[] parseNames(final String names) {
        if (StringUtils.isBlank(names)) {
            throw new UserException("참가자를 입력해주세요.");
        }

        return names.replaceAll(" ", "").trim().split(",");
    }

    private List<String> validate(final String[] parseNames) {
        if (hasDuplicatedName(parseNames)) {
            throw new UserException("참가자 이름이 중복됩니다.");
        }

        if (isInsufficientNumberOfUsers(parseNames)) {
            throw new UserException("참가자 수는 최소 2명 이상입니다.");
        }

        return Arrays.asList(parseNames);
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
