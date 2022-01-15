package ru.vsu.cs.roshchupkin_ya_a.model.gamefield;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GameField {
    private Map<Coordinate, Cell> coordinateCellMap;
    private Map<Cell, Coordinate> cellCoordinateMap;

    public GameField() {
        coordinateCellMap = new TreeMap<>();
        cellCoordinateMap = new HashMap<>();
    }

    public GameField(Map<Coordinate, Cell> coordinateCellMap) {
        this.coordinateCellMap = coordinateCellMap;
    }

    public void addCell(Coordinate coordinate, Cell cell) {
        coordinateCellMap.put(coordinate, cell);
    }
/*
    public boolean isCellOnEdge(Cell cell) {
        Coordinate coordinate = cellCoordinateMap.get(cell);
        return coordinate.getX() != 0 && coordinate.getX() != Coordinate.getXLength() &&;
    }
*/
    public Collection<Cell> getCells() {
        return coordinateCellMap.values();
    }

    public Map<Coordinate, Cell> getCoordinateCellMap() {
        return coordinateCellMap;
    }

    public Map<Cell, Coordinate> getCellCoordinateMap() {
        return cellCoordinateMap;
    }

    public void setCoordinateCellMap(Map<Coordinate, Cell> coordinateCellMap) {
        this.coordinateCellMap = coordinateCellMap;
    }

    public void setCellCoordinateMap(Map<Cell, Coordinate> cellCoordinateMap) {
        this.cellCoordinateMap = cellCoordinateMap;
    }
}
