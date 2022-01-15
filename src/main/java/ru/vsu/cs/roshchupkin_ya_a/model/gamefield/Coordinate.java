package ru.vsu.cs.roshchupkin_ya_a.model.gamefield;

import ru.vsu.cs.roshchupkin_ya_a.model.direction.Direction;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {
    private static int xLength = 1;

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int getXLength() {
        return xLength;
    }

    public static void setXLength(int xLength) {
        Coordinate.xLength = xLength;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    public Coordinate getNeighbor(Direction direction) {
        return switch (direction) {
            case UP -> new Coordinate(x, y - 1);
            case RIGHT -> new Coordinate(x + 1, y);
            case DOWN -> new Coordinate(x, y + 1);
            case LEFT -> new Coordinate(x - 1, y);
        };
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Coordinate o) {
        if (y == o.y) {
            return x - o.x;
        } else {
            //return (y - o.y) * xLength + x - o.x;
            return y - o.y;
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
