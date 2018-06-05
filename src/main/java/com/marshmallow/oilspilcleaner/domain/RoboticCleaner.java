package com.marshmallow.oilspilcleaner.domain;

import com.marshmallow.oilspilcleaner.command.Command;
import com.marshmallow.oilspilcleaner.exception.OutOfBoundsException;
import com.marshmallow.oilspilcleaner.parser.NavigationInstructionsParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RoboticCleaner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoboticCleaner.class);

    private List<Integer> currentPosition;
    private int oilPatchesCleanedCount;

    public RoboticCleaner(List<Integer> currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void clean(String navigationInstructions, SeaArea seaArea) {
        List<Command> commands = new NavigationInstructionsParser(navigationInstructions).toCommands();
        for (Command command : commands) {
            LOGGER.info("Cleaner is moving...");
            String commandType = command.getClass().getSimpleName();
            LOGGER.debug("Invoking " +commandType+ " to cleaner");
            this.currentPosition = command.move(this);
            checkBoundariesAndDirtiness(this.currentPosition, seaArea);
        }
    }

    private void checkBoundariesAndDirtiness(List<Integer> position, SeaArea seaArea) {
        int x = position.get(0);
        int y = position.get(1);
        LOGGER.info("Checking if current position is within bounds");
        if (seaArea.isWithinBounds(position)) {
            LOGGER.info("Position ["+x+", "+y+"] is within bounds");
            LOGGER.info("Checking if current position has an oil spil");
            if (seaArea.isDirty(position)) {
                LOGGER.info("Position ["+x+", "+y+"] has oil spil");
                this.oilPatchesCleanedCount++;
                seaArea.removeDirt(position);
            }
            LOGGER.info("Position ["+x+", "+y+"] is clean");
        } else {
            LOGGER.error("Position ["+x+", "+y+"] is out of bounds!");
            throw new OutOfBoundsException("Position ["+x+", "+y+"] is out of bounds!");
        }
    }

    public List<Integer> getCurrentPosition() {
        return currentPosition;
    }

    public int getOilPatchesCleanedCount() {
        return oilPatchesCleanedCount;
    }
}
