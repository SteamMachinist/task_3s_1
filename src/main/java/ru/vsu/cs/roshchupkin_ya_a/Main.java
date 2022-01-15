package ru.vsu.cs.roshchupkin_ya_a;

import ru.vsu.cs.roshchupkin_ya_a.model.Game;
import ru.vsu.cs.roshchupkin_ya_a.model.Player;
import ru.vsu.cs.roshchupkin_ya_a.service.GameService;
import ru.vsu.cs.roshchupkin_ya_a.view.MainFrame;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SwingUtilities.invokeLater(MainFrame::new);

        GameService service = new GameService();

        List<Player> players = new LinkedList<>();
        players.add(new Player("Andrew"));
        players.add(new Player("Johan"));
        Game game = service.createGame(players);

        service.processGame(game);

        System.out.println(game);
    }
}
