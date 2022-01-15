package ru.vsu.cs.roshchupkin_ya_a.service.placer;

import ru.vsu.cs.roshchupkin_ya_a.model.Game;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.Cell;
import ru.vsu.cs.roshchupkin_ya_a.model.gameobjects.DestructibleWall;
import ru.vsu.cs.roshchupkin_ya_a.model.gameobjects.GameObject;
import ru.vsu.cs.roshchupkin_ya_a.model.gameobjects.IndestructibleWall;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WallPlacerService implements IWallPlacerService{
    @Override
    public void placeBorderWalls(Game game) {
        Map<Cell, GameObject> cellToObjectMap = game.getCellToObjectMap();
        Map<GameObject, Cell> objectToCellMap = game.getObjectToCellMap();

        for (Cell cell : game.getGameField().getCells()) {
            if (!cell.isInner() ) {
                IndestructibleWall indestructibleWall = new IndestructibleWall();
                cellToObjectMap.put(cell, indestructibleWall);
                objectToCellMap.put(indestructibleWall, cell);
            }
        }
        game.setCellToObjectMap(cellToObjectMap);
        game.setObjectToCellMap(objectToCellMap);
    }

    @Override
    public void placeInnerWalls(Game game) {
        Map<Cell, GameObject> cellToObjectMap = game.getCellToObjectMap();
        Map<GameObject, Cell> objectToCellMap = game.getObjectToCellMap();

        List<Cell> cells = new LinkedList<>(game.getGameField().getCells());
        Collections.shuffle(cells);
        int wallsPlaced = 0;
        for (Cell cell : cells) {
            if (!cellToObjectMap.containsKey(cell) && wallsPlaced < game.getInnerDestructibleWallsCount()) {
                DestructibleWall destructibleWall = new DestructibleWall(game.getDestructibleWallsHP());
                cellToObjectMap.put(cell, destructibleWall);
                objectToCellMap.put(destructibleWall, cell);
                wallsPlaced++;
            }
        }
        game.setCellToObjectMap(cellToObjectMap);
        game.setObjectToCellMap(objectToCellMap);
    }
}
