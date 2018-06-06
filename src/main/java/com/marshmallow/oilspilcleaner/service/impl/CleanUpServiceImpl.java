package com.marshmallow.oilspilcleaner.service.impl;

import com.marshmallow.oilspilcleaner.domain.RoboticCleaner;
import com.marshmallow.oilspilcleaner.domain.SeaArea;
import com.marshmallow.oilspilcleaner.exception.OutOfBoundsException;
import com.marshmallow.oilspilcleaner.resource.CleanUpInstructions;
import com.marshmallow.oilspilcleaner.resource.CleanUpResult;
import com.marshmallow.oilspilcleaner.service.CleanUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanUpServiceImpl implements CleanUpService {

    private static  final Logger LOGGER = LoggerFactory.getLogger(CleanUpServiceImpl.class);

    @Override
    public CleanUpResult run(CleanUpInstructions cleanUpInstructions) {
        RoboticCleaner roboticCleaner = cleanUpInstructions.getRoboticCleaner();
        SeaArea seaArea = cleanUpInstructions.getSeaArea();
        String navigationInstructions = cleanUpInstructions.getNavigationInstructions();

        LOGGER.info("Checking if robotic cleaner is placed within the sea area");
        if (!seaArea.isWithinBounds(roboticCleaner.getCurrentPosition())) {
            int x = roboticCleaner.getCurrentPosition().get(0);
            int y = roboticCleaner.getCurrentPosition().get(1);
            LOGGER.error("Starting position ["+x+", "+y+"] is out of bounds!");
            throw new OutOfBoundsException("Starting position ["+x+", "+y+"] is out of bounds!");
        }

        LOGGER.info("Give Instructions to Robotic Cleaner");
        roboticCleaner.clean(navigationInstructions, seaArea);

        List<Integer> cleanerPosition = roboticCleaner.getCurrentPosition();
        int oilPatchesCleanedCount = roboticCleaner.getOilPatchesCleanedCount();
        return new CleanUpResult(cleanerPosition, oilPatchesCleanedCount);
    }
}
