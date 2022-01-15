package ru.vsu.cs.roshchupkin_ya_a.model.gamefield;

import ru.vsu.cs.roshchupkin_ya_a.model.direction.Direction;

import java.util.HashMap;
import java.util.Map;

public class Cell {
    private Map<Direction, Cell> neighbors;

    public Cell() {
        neighbors = new HashMap<>();
    }

    public Cell(Map<Direction, Cell> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Direction direction, Cell cell) {
        neighbors.put(direction, cell);
    }

    public boolean isInner() {
        return neighbors.size() == 4;
    }

    public Map<Direction, Cell> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Map<Direction, Cell> neighbors) {
        this.neighbors = neighbors;
    }
}
