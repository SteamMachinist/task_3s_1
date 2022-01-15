package ru.vsu.cs.roshchupkin_ya_a.model.gameobjects;

import ru.vsu.cs.roshchupkin_ya_a.model.direction.Direction;

public class Shell {
    private Direction direction;

    public Shell(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
