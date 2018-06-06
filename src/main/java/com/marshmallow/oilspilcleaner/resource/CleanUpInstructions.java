package com.marshmallow.oilspilcleaner.resource;

import com.marshmallow.oilspilcleaner.domain.RoboticCleaner;
import com.marshmallow.oilspilcleaner.domain.SeaArea;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CleanUpInstructions {
    @NotNull
    @Size(min = 2, max = 2)
    private final List<Integer> areaSize;

    @NotNull
    @Size(min = 2, max = 2)
    private final List<Integer> startingPosition;

    private final List<List<Integer>> oilPatches;
    private final String navigationInstructions;

    private SeaArea seaArea;
    private RoboticCleaner roboticCleaner;

    public CleanUpInstructions(List<Integer> areaSize, List<Integer> startingPosition, List<List<Integer>> oilPatches, String navigationInstructions) {
        this.areaSize = areaSize;
        this.startingPosition = startingPosition;
        this.oilPatches = oilPatches;
        this.navigationInstructions = navigationInstructions;

        this.seaArea = new SeaArea(areaSize, oilPatches);
        this.roboticCleaner = new RoboticCleaner(startingPosition);
    }

    public List<Integer> getAreaSize() {
        return areaSize;
    }

    public List<Integer> getStartingPosition() {
        return startingPosition;
    }

    public List<List<Integer>> getOilPatches() {
        return oilPatches;
    }

    public String getNavigationInstructions() {
        return navigationInstructions;
    }

    public SeaArea getSeaArea() {
        return seaArea;
    }

    public RoboticCleaner getRoboticCleaner() {
        return roboticCleaner;
    }

}
