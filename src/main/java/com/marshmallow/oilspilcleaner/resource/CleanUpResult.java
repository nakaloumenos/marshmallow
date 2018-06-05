package com.marshmallow.oilspilcleaner.resource;

import java.util.List;

public class CleanUpResult {
    private final List<Integer> finalPosition;
    private final int oilPatchesCleaned;

    public CleanUpResult(List<Integer> finalPosition, int oilPatchesCleaned) {
        this.finalPosition = finalPosition;
        this.oilPatchesCleaned = oilPatchesCleaned;
    }

    public List<Integer> getFinalPosition() {
        return finalPosition;
    }

    public int getOilPatchesCleaned() {
        return oilPatchesCleaned;
    }
}
