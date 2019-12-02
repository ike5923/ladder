package ladder.domain;

import ladder.domain.exception.UserException;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {

    private final List<String> rewardNames;
    private Map<String, String> results = new HashMap<>();

    public Rewards(final String inputRewards) {
        this.rewardNames = parsedRewards(inputRewards);
    }

    private List<String> parsedRewards(final String inputRewards) {
        if (StringUtils.isBlank(inputRewards)) {
            throw new UserException("실행 결과를 입력해주세요.");
        }

        return Arrays.asList(inputRewards.replaceAll(" ", "").trim().split(","));
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
        return results.get(userName);
    }

    public Map<String, String> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
