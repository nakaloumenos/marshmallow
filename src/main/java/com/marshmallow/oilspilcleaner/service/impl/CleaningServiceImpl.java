package com.marshmallow.oilspilcleaner.service.impl;

import com.marshmallow.oilspilcleaner.domain.RoboticCleaner;
import com.marshmallow.oilspilcleaner.domain.SeaArea;
import com.marshmallow.oilspilcleaner.resource.CleanUpInstructions;
import com.marshmallow.oilspilcleaner.resource.CleanUpResult;
import com.marshmallow.oilspilcleaner.service.CleaningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleaningServiceImpl implements CleaningService{

    private static  final Logger LOGGER = LoggerFactory.getLogger(CleaningServiceImpl.class);

    @Override
    public CleanUpResult run(CleanUpInstructions cleanUpInstructions) {
        RoboticCleaner roboticCleaner = cleanUpInstructions.getRoboticCleaner();
        SeaArea seaArea = cleanUpInstructions.getSeaArea();
        String navigationInstructions = cleanUpInstructions.getNavigationInstructions();

        LOGGER.info("Give Instructions to Robotic Cleaner");
        roboticCleaner.clean(navigationInstructions, seaArea);

        List<Integer> cleanerPosition = roboticCleaner.getCurrentPosition();
        int oilPatchesCleanedCount = roboticCleaner.getOilPatchesCleanedCount();
        return new CleanUpResult(cleanerPosition, oilPatchesCleanedCount);
    }
}
