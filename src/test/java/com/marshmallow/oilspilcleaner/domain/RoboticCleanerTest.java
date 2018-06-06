package com.marshmallow.oilspilcleaner.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class RoboticCleanerTest {

    private RoboticCleaner roboticCleaner;
    private SeaArea seaArea;

    @Before
    public void setUp() {
        List<Integer> startingPosition = Arrays.asList(1, 2);
        roboticCleaner = new RoboticCleaner(startingPosition);
    }

    @Test
    public void canProvideCurrentLocationAsString() {

        //Then
        Assert.assertEquals(Arrays.asList(1, 2), roboticCleaner.getCurrentPosition());
    }

    @Test
    public void canClean() {
        //Given
        String navigationInstructions = "NNESEESWNWW";
        List<Integer> topRight = Arrays.asList(5, 5);
        List<Integer> oilPatch = Collections.emptyList();
        List<List<Integer>> oilPatches = Collections.singletonList(oilPatch);
        SeaArea seaArea = new SeaArea(topRight, oilPatches);

        //When
        roboticCleaner.clean(navigationInstructions, seaArea);

        //Then
        Assert.assertEquals(Arrays.asList(1, 3), roboticCleaner.getCurrentPosition());
    }

}
