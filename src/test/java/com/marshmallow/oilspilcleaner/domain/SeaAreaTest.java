package com.marshmallow.oilspilcleaner.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SeaAreaTest {

    private SeaArea seaArea;

    @Before
    public void setUp() {
        List<Integer> topRight = Arrays.asList(5, 5);
        List<Integer> oilPatch = Arrays.asList(2, 3);
        List<List<Integer>> oilPatches = Arrays.asList(oilPatch);
        seaArea = new SeaArea(topRight, oilPatches);
    }


    @Test
    public void positionWithCoordinateWithinBoundsIsIdentified() {
        //Given
        List<Integer> position = Arrays.asList(5, 0);

        //Then
        Assert.assertTrue(seaArea.contains(position));
    }

    @Test
    public void positionWithPositiveXCoordinateOutsideBoundsIsIdentified() {
        //Given
        List<Integer> position = Arrays.asList(6, 0);

        //Then
        Assert.assertFalse(seaArea.contains(position));
    }

    @Test
    public void positionWithNegativeXCoordinateOutsideBoundsIsIdentified() {
        //Given
        List<Integer> position = Arrays.asList(-1, 0);


        //Then
        Assert.assertFalse(seaArea.contains(position));
    }

    @Test
    public void positionWithPositiveYCoordinateOutsideBoundsIsIdentified() {

        //Given
        List<Integer> position = Arrays.asList(0, 6);


        //Then
        Assert.assertFalse(seaArea.contains(position));
    }

    @Test
    public void positionWithNegativeYCoordinateOutsideBoundsIsIdentified() {

        //Given
        List<Integer> position = Arrays.asList(0, -1);


        //Then
        Assert.assertFalse(seaArea.contains(position));
    }

    @Test
    public void positionWithoutOilSpilIsIdentified() {

        //Given
        List<Integer> position = Arrays.asList(1, 0);


        //Then
        Assert.assertFalse(seaArea.hasOilPatchIn(position));
    }

    @Test
    public void positionWithOilPatchIsIdentified() {

        //Given
        List<Integer> position = Arrays.asList(2, 3);


        //Then
        Assert.assertTrue(seaArea.hasOilPatchIn(position));
    }

}
