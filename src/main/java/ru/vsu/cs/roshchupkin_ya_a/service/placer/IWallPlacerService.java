package ru.vsu.cs.roshchupkin_ya_a.service.placer;

import ru.vsu.cs.roshchupkin_ya_a.model.Game;

public interface IWallPlacerService {
    void placeBorderWalls(Game game);
    void placeInnerWalls(Game game);
}
