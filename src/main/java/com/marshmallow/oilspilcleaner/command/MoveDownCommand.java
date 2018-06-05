package com.marshmallow.oilspilcleaner.command;

import com.marshmallow.oilspilcleaner.domain.RoboticCleaner;

import java.util.ArrayList;
import java.util.List;

public class MoveDownCommand implements Command{
    @Override
    public List<Integer> move(RoboticCleaner roboticCleaner) {
        List<Integer> currentPosition = roboticCleaner.getCurrentPosition();
        int oldY = currentPosition.get(1);
        int newY = oldY - 1;
        currentPosition.set(1, newY);
        return currentPosition;
    }
}
