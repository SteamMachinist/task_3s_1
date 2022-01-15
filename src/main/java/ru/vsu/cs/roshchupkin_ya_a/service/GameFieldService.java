package ru.vsu.cs.roshchupkin_ya_a.service;

import ru.vsu.cs.roshchupkin_ya_a.model.direction.Direction;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Cell;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Coordinate;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.GameField;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameFieldService {
    public GameField createGameField(String stringField) {
        TreeMap<Coordinate, Cell> coordinateCellMap = createCoordinateCellsMap(stringField);
/*
        for (Coordinate coordinate = new Coordinate(0, 0); coordinate.compareTo(coordinateCellMap.lastKey()) <= 0; ) {
            System.out.println(coordinate + " " + coordinateCellMap.get(coordinate));
            if (coordinate.getX() >= Coordinate.getXLength()) {
                coordinate.setY(coordinate.getY() + 1);
                coordinate.setX(0);
            } else coordinate.setX(coordinate.getX() + 1);
        }*/

       /* for (Map.Entry<Coordinate, Cell> entry : coordinateCellMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " " + entry.getValue().toString());
        }*/

        connectCells(coordinateCellMap);
        return new GameField(coordinateCellMap);
    }

    private TreeMap<Coordinate, Cell> createCoordinateCellsMap(String stringField) {
        Coordinate.setXLength(stringField.indexOf("\r\n"));
        System.out.println(Coordinate.getXLength());

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
