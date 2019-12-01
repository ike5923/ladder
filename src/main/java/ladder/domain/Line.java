package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Position> positions = new ArrayList<>();

    public Line(int countOfPerson, ValueGenerator valueGenerator) {
        positions.add(Position.first(valueGenerator));
        while (countOfPerson-- > 2) {
            positions.add(getLastPosition().next(valueGenerator));
        }
        positions.add(getLastPosition().last());
    }

    private Position getLastPosition() {
        return positions.get(positions.size() - 1);
    }

    public List<Position> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}
