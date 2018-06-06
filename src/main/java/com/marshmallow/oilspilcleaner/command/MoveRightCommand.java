package com.marshmallow.oilspilcleaner.command;

import com.marshmallow.oilspilcleaner.domain.RoboticCleaner;

import java.util.List;

public class MoveRightCommand implements Command{
    @Override
    public List<Integer> move(RoboticCleaner roboticCleaner) {
        List<Integer> currentPosition = roboticCleaner.getCurrentPosition();
        int oldX = currentPosition.get(0);
        int newX = oldX + 1;
        currentPosition.set(0, newX);
        return currentPosition;
    }
}
