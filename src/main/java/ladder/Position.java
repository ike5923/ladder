package ladder;

import java.util.Objects;

/**
 * left == true && current == false 일 경우 : 왼쪽 지점과 그 좌측 지점이 연결되어 있다.
 * left == true && current == true 일 경우 : 왼쪽 지점과 현재 지점이 연결되어 있다.
 * left == false && current == true 일 경우 : 현재 지점과 오른쪽 지점이 연결되어 있다.
 */
public class Position {

    private boolean left;
    private boolean current;

    private Position(final boolean left, final boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Position of(final boolean left, final boolean current) {
        return new Position(left, current);
    }

    public static Position first(ValueGenerator valueGenerator) {
        return of(false, valueGenerator.generate());
    }

    public Position last() {
        return of(current, false);
    }

    public Position next(ValueGenerator valueGenerator) {
        if (current) {
            return of(true, false);
        }

        return of(false, valueGenerator.generate());
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isCurrent() {
        return current;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return left == position.left &&
                current == position.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
