package ladder.domain;

import ladder.controller.ValueGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Position> positions = new ArrayList<>();

    public Line(int countOfUsers, ValueGenerator valueGenerator) {
        positions.add(Position.first(valueGenerator));
        while (countOfUsers-- > 2) {
            positions.add(getLastPosition().next(valueGenerator));
        }
        positions.add(getLastPosition().last());
    }

    public int nextLineNumber(int currentLineNumber) {
        Position position = positions.get(currentLineNumber);
        return currentLineNumber + position.getDirection();
    }

    private Position getLastPosition() {
        return positions.get(positions.size() - 1);
    }

    public List<Position> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}
