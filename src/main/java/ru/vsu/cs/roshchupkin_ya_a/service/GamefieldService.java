package ru.vsu.cs.roshchupkin_ya_a.service;

import ru.vsu.cs.roshchupkin_ya_a.model.direction.Direction;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Cell;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Coordinate;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Gamefield;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GamefieldService {
    public Gamefield createGameField(String stringField) {
        TreeMap<Coordinate, Cell> coordinateCellMap = createCoordinateCellsMap(stringField);
        connectCells(coordinateCellMap);
        return new Gamefield(coordinateCellMap);
    }

    private TreeMap<Coordinate, Cell> createCoordinateCellsMap(String stringField) {
        Coordinate.setXLength(stringField.indexOf("\r\n"));
        char[] charFieldArray = stringField.replace("\r\n", "").toCharArray();

        return IntStream.range(0, charFieldArray.length)
                .boxed()
                .filter(i -> charFieldArray[i] == '1')
                .collect(Collectors.toMap(
                        i -> {
                            int y = i / (Coordinate.getXLength());
                            return new Coordinate(i - y * (Coordinate.getXLength()), y);
                        },
                        i -> new Cell(),
                        (cell, cell2) -> cell,
                        TreeMap::new));
    }

    private void connectCells(TreeMap<Coordinate, Cell> coordinateCellMap) {
        Set<Map.Entry<Coordinate, Cell>> coordinateCellSet = coordinateCellMap.entrySet();
        for (Map.Entry<Coordinate, Cell> entry : coordinateCellSet) {
            for (Direction direction : Direction.values()) {
                Cell neighbor = coordinateCellMap.get(entry.getKey().getNeighbor(direction));
                if (neighbor != null) {
                    entry.getValue().addNeighbor(direction, neighbor);
                }
            }
        }
    }

}
