package com.marshmallow.oilspilcleaner.command;

import com.marshmallow.oilspilcleaner.domain.RoboticCleaner;

import java.util.List;

public interface Command {
    List<Integer> move(RoboticCleaner roboticCleaner);
}
