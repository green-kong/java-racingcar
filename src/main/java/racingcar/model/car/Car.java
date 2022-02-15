package racingcar.model.car;

import racingcar.model.value.Name;
import racingcar.model.value.Position;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private static final int STANDARD_VALUE = 4;

    private final Name name;
    private final Position position;

    public Car(String nameString) {
        this.name = new Name(nameString);
        this.position = new Position();
    }

    public void goOrStop(int random) {
        if (random >= STANDARD_VALUE) {
            position.move(MOVING_DISTANCE);
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.toInt() == maxPosition;
    }

    public String getName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position.toInt();
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }

}