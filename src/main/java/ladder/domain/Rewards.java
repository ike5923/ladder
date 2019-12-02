package ladder.domain;

import ladder.domain.exception.RewardException;
import ladder.domain.exception.UserException;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {

    private final List<String> rewardNames;
    private Map<String, String> results = new HashMap<>();

    public Rewards(final String inputRewards, int countOfUsers) {
        this.rewardNames = validate(parsedRewards(inputRewards), countOfUsers);
    }

    private List<String> parsedRewards(final String inputRewards) {
        if (StringUtils.isBlank(inputRewards)) {
            throw new UserException("실행 결과를 입력해주세요.");
        }

        return Arrays.asList(inputRewards.replaceAll(" ", "").trim().split(","));
    }

    private List<String> validate(final List<String> parsedRewards, final int countOfUsers) {
        if (isDifferentNumberOf(parsedRewards.size(), countOfUsers)) {
            throw new RewardException("참가자 수와 결과 수가 맞지 않습니다.");
        }

        return parsedRewards;
    }

    private boolean isDifferentNumberOf(final int countOfRewards, final int countOfUsers) {
        return countOfRewards != countOfUsers;
    }

    public void init(final List<User> users) {
        List<String> userNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());

        List<String> sortedRewards = users.stream()
                .map(User::getLineNumber)
                .map(rewardNames::get)
                .collect(Collectors.toList());

        IntStream.rangeClosed(0, sortedRewards.size() - 1)
                .forEach(idx -> results.put(userNames.get(idx), sortedRewards.get(idx)));
    }

    public String getResult(String userName) {
        String result = results.get(userName);
        if (result == null) {
            throw new RewardException("해당하는 결과가 없습니다.");
        }

        return result;
    }

    public Map<String, String> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
