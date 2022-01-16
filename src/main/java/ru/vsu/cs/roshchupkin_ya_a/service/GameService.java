package ru.vsu.cs.roshchupkin_ya_a.service;

import ru.vsu.cs.roshchupkin_ya_a.model.Game;
import ru.vsu.cs.roshchupkin_ya_a.model.Player;
import ru.vsu.cs.roshchupkin_ya_a.model.gamefield.GameField;
import ru.vsu.cs.roshchupkin_ya_a.service.placer.IWallPlacerService;
import ru.vsu.cs.roshchupkin_ya_a.service.placer.WallPlacerService;
import ru.vsu.cs.roshchupkin_ya_a.utils.TextFileUtils;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class GameService {
    public GameService() {
    }

    public Game createGame(List<Player> players) {
        Game game = new Game();
        createPlayers(game, players);
        createGameField(game);
        game.setCellToObjectMap(new HashMap<>());
        game.setObjectToCellMap(new HashMap<>());
        createWalls(game);
        game.setCellToShellMap(new HashMap<>());
        return game;
    }

    private void createPlayers(Game game, List<Player> players) {
        Queue<Player> playerQueue = new ArrayDeque<>(players);
        game.setPlayersQueue(playerQueue);
    }

    private void createGameField(Game game) {
        GameFieldService gameFieldService = new GameFieldService();
        try {
            game.setGameField(gameFieldService.createGameField(TextFileUtils.read()));
        } catch (FileNotFoundException e) {
            game.setGameField(new GameField());
        }
    }

    private void createWalls(Game game) {
        IWallPlacerService wallPlacerService = new WallPlacerService();
        wallPlacerService.placeBorderWalls(game);
        wallPlacerService.placeInnerWalls(game);
    }

    public void processGame(Game game) {
        System.out.println("game runs");
    }

    public void printGame() {
    }
}
