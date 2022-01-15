package ru.vsu.cs.roshchupkin_ya_a.model;

import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Cell;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Coordinate;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.GameField;
import ru.vsu.cs.roshchupkin_ya_a.model.gameobjects.*;

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Game {

    private final int innerDestructibleWallsCount = 10;
    private final int destructibleWallsHP = 5;

    private Queue<Player> playersQueue;
    private Map<Player, Queue<Tank>> playerTanksQueueMap;
    private GameField gameField;
    private Map<Cell, GameObject> cellToObjectMap;
    private Map<GameObject, Cell> objectToCellMap;
    private Map<Tank, Shell> tankToShellMap;
    private Map<Shell, Tank> shellToTankMap;
    private Map<Shell, Cell> shellToCellMap;
    private Map<Cell, Shell> cellToShellMap;

    public Game() {
    }

    public int getInnerDestructibleWallsCount() {
        return innerDestructibleWallsCount;
    }

    public int getDestructibleWallsHP() {
        return destructibleWallsHP;
    }

    public Queue<Player> getPlayersQueue() {
        return playersQueue;
    }

    public void setPlayersQueue(Queue<Player> playersQueue) {
        this.playersQueue = playersQueue;
    }

    public Map<Player, Queue<Tank>> getPlayerTanksQueueMap() {
        return playerTanksQueueMap;
    }

    public void setPlayerTanksQueueMap(Map<Player, Queue<Tank>> playerTanksQueueMap) {
        this.playerTanksQueueMap = playerTanksQueueMap;
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public Map<Cell, GameObject> getCellToObjectMap() {
        return cellToObjectMap;
    }

    public void setCellToObjectMap(Map<Cell, GameObject> cellToObjectMap) {
        this.cellToObjectMap = cellToObjectMap;
    }

    public Map<GameObject, Cell> getObjectToCellMap() {
        return objectToCellMap;
    }

    public void setObjectToCellMap(Map<GameObject, Cell> objectToCellMap) {
        this.objectToCellMap = objectToCellMap;
    }

    public Map<Tank, Shell> getTankToShellMap() {
        return tankToShellMap;
    }

    public void setTankToShellMap(Map<Tank, Shell> tankToShellMap) {
        this.tankToShellMap = tankToShellMap;
    }

    public Map<Shell, Tank> getShellToTankMap() {
        return shellToTankMap;
    }

    public void setShellToTankMap(Map<Shell, Tank> shellToTankMap) {
        this.shellToTankMap = shellToTankMap;
    }

    public Map<Shell, Cell> getShellToCellMap() {
        return shellToCellMap;
    }

    public void setShellToCellMap(Map<Shell, Cell> shellToCellMap) {
        this.shellToCellMap = shellToCellMap;
    }

    public Map<Cell, Shell> getCellToShellMap() {
        return cellToShellMap;
    }

    public void setCellToShellMap(Map<Cell, Shell> cellToShellMap) {
        this.cellToShellMap = cellToShellMap;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<Coordinate, Cell> coordinateToCellMap = (TreeMap<Coordinate, Cell>) gameField.getCoordinateCellMap();
        for (Coordinate coordinate = new Coordinate(0, 0);
             coordinate.compareTo(coordinateToCellMap.lastKey()) <= 0; ) {
            Cell cell = coordinateToCellMap.get(coordinate);
            if (cell == null) {
                stringBuilder.append(" ");
            } else if (cellToObjectMap.get(cell) instanceof IndestructibleWall) {
                stringBuilder.append("#");
            } else if (cellToObjectMap.get(cell) instanceof DestructibleWall) {
                stringBuilder.append("D");
            } else if (cellToObjectMap.get(cell) instanceof Tank) {
                stringBuilder.append("T");
            } else {
                stringBuilder.append(".");
            }

            if (coordinate.getX() >= Coordinate.getXLength() - 1) {
                stringBuilder.append("\n");
                coordinate.setY(coordinate.getY() + 1);
                coordinate.setX(0);
            } else coordinate.setX(coordinate.getX() + 1);
        }
        /*Coordinate oldCoordinate = coordinateToCellMap.firstKey();
        for (Map.Entry<Coordinate, Cell> entry : coordinateToCellMap.entrySet()) {
            Coordinate coordinate = entry.getKey();
            if (oldCoordinate.getY() != coordinate.getY()) {
                stringBuilder.append("\n");
            }
            else if ((coordinate.getX() - oldCoordinate.getX()) != 1){
                stringBuilder.append(" ".repeat(Math.max(0, (coordinate.getX() - oldCoordinate.getX()))));
            }
            Cell cell = entry.getValue();
            if (cell == null) {
                stringBuilder.append(" ");
            } else if (cellToObjectMap.get(cell) instanceof IndestructibleWall) {
                stringBuilder.append("#");
            } else if (cellToObjectMap.get(cell) instanceof DestructibleWall) {
                stringBuilder.append("D");
            } else if (cellToObjectMap.get(cell) instanceof Tank) {
                stringBuilder.append("T");
            } else {
                stringBuilder.append(".");
            }
            oldCoordinate = coordinate;
        }*/
        return stringBuilder.toString();
    }
}
