package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("왼쪽 끝 점 생성")
    void createLeftEndPosition() {
        Position leftEndPosition = Position.of(false, true);
        assertThat(leftEndPosition.isLeft()).isFalse();
    }

    @Test
    @DisplayName("오른쪽 끝 점 생성")
    void createRightEndPosition() {
        Position leftEndPosition = Position.of(false, false);
        assertThat(leftEndPosition.isCurrent()).isFalse();
    }

    @Test
    @DisplayName("양쪽 점이 연결되어있지 않은 점 생성")
    void createNotConnectedLeftPosition() {
        Position connectedLeftPosition = Position.of(false, false);
        assertThat(connectedLeftPosition.isLeft()).isFalse();
        assertThat(connectedLeftPosition.isCurrent()).isFalse();
    }

    @Test
    @DisplayName("왼쪽 점과 연결된 점 생성")
    void createConnectedCurrentPosition() {
        Position connectedLeftPosition = Position.of(true, true);
        assertThat(connectedLeftPosition.isLeft()).isTrue();
        assertThat(connectedLeftPosition.isCurrent()).isTrue();
    }

    @Test
    @DisplayName("오른쪽 점과 연결된 점 생성")
    void createConnectedRightPosition() {
        Position connectedRightPosition = Position.of(false, true);
        assertThat(connectedRightPosition.isLeft()).isFalse();
        assertThat(connectedRightPosition.isCurrent()).isTrue();
    }

    @Test
    @DisplayName("현재 점과 연결된 다음 점 생성")
    void createNextPosition() {
        Position currentPosition = Position.of(false, true);
        Position nextPosition = currentPosition.next(() -> true);
        assertThat(nextPosition.isLeft()).isTrue();
        assertThat(nextPosition.isCurrent()).isFalse();
    }

    @Test
    @DisplayName("현재 점과 연결되지 않는 다음 점 생성")
    void createNotConnectedNextPosition() {
        Position currentPosition = Position.of(false, false);
        Position nextPosition = currentPosition.next(() -> true);
        assertThat(nextPosition.isLeft()).isFalse();
        assertThat(nextPosition.isCurrent()).isTrue();
    }
}