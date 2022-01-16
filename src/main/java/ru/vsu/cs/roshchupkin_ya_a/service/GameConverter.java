package ru.vsu.cs.roshchupkin_ya_a.service;

import ru.vsu.cs.roshchupkin_ya_a.model.Game;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Cell;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Coordinate;
import ru.vsu.cs.roshchupkin_ya_a.model.gameobjects.DestructibleWall;
import ru.vsu.cs.roshchupkin_ya_a.model.gameobjects.GameObject;
import ru.vsu.cs.roshchupkin_ya_a.model.gameobjects.IndestructibleWall;
import ru.vsu.cs.roshchupkin_ya_a.model.gameobjects.Tank;

import java.util.TreeMap;

public class GameConverter {
    public static String asString(Game game) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<Coordinate, Cell> coordinateToCellMap = (TreeMap<Coordinate, Cell>) game.getGameField().getCoordinateCellMap();
        for (Coordinate coordinate = new Coordinate(0, 0);
             coordinate.compareTo(coordinateToCellMap.lastKey()) <= 0; ) {
            Cell cell = coordinateToCellMap.get(coordinate);
            GameObject gameObject = game.getCellToObjectMap().get(cell);
            if (cell == null) {
                stringBuilder.append(" ");
            } else if (game.getCellToShellMap().get(cell) != null) {
                stringBuilder.append("*");
            } else if (gameObject instanceof IndestructibleWall) {
                stringBuilder.append("#");
            } else if (gameObject instanceof DestructibleWall) {
                stringBuilder.append("D");
            } else if (gameObject instanceof Tank) {
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
        return stringBuilder.toString();
    }

    public static String[][] asString2DArray(Game game) {
        TreeMap<Coordinate, Cell> coordinateToCellMap = (TreeMap<Coordinate, Cell>) game.getGameField().getCoordinateCellMap();
        String[][] gameField = new String[coordinateToCellMap.lastKey().getY() + 1][Coordinate.getXLength()];
        for (Coordinate coordinate = new Coordinate(0, 0);
             coordinate.compareTo(coordinateToCellMap.lastKey()) <= 0; ) {
            Cell cell = coordinateToCellMap.get(coordinate);
            GameObject gameObject = game.getCellToObjectMap().get(cell);
            if (cell == null) {
                gameField[coordinate.getY()][coordinate.getX()] = "";
            } else if (game.getCellToShellMap().get(cell) != null) {
                gameField[coordinate.getY()][coordinate.getX()] = "⁕";
            } else if (gameObject instanceof IndestructibleWall) {
                gameField[coordinate.getY()][coordinate.getX()] = "⛝";
            } else if (gameObject instanceof DestructibleWall) {
                gameField[coordinate.getY()][coordinate.getX()] = "⛋";
            } else if (gameObject instanceof Tank) {
                gameField[coordinate.getY()][coordinate.getX()] = "Ѫ";
            } else {
                gameField[coordinate.getY()][coordinate.getX()] = "\uD83D\uDF84";
            }
            if (coordinate.getX() >= Coordinate.getXLength() - 1) {
                coordinate.setY(coordinate.getY() + 1);
                coordinate.setX(0);
            } else coordinate.setX(coordinate.getX() + 1);
        }
        return gameField;
    }
}
