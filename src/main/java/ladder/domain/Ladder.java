package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(final Height height, final int countOfPerson, ValueGenerator valueGenerator) {
        List<Line> createdLines = initLines(height, countOfPerson, valueGenerator);
        this.lines.addAll(createdLines);
    }

    private List<Line> initLines(final Height height, final int countOfPerson, final ValueGenerator valueGenerator) {
        return IntStream.rangeClosed(1, height.getValue())
                .mapToObj(i -> new Line(countOfPerson, valueGenerator))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
