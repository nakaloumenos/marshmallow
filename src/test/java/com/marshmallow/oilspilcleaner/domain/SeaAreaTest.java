package com.marshmallow.oilspilcleaner.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marshmallow.oilspilcleaner.resource.CleanUpInstructions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
        Assert.assertTrue(seaArea.isWithinBounds(position));
    }

    @Test
    public void positionWithPositiveXCoordinateOutsideBoundsIsIdentified() {
        //Given
        List<Integer> position = Arrays.asList(6, 0);

        //Then
        Assert.assertFalse(seaArea.isWithinBounds(position));
    }

    @Test
    public void positionWithNegativeXCoordinateOutsideBoundsIsIdentified() {
        //Given
        List<Integer> position = Arrays.asList(-1, 0);


        //Then
        Assert.assertFalse(seaArea.isWithinBounds(position));
    }

    @Test
    public void positionWithPositiveYCoordinateOutsideBoundsIsIdentified() {

        //Given
        List<Integer> position = Arrays.asList(0, 6);


        //Then
        Assert.assertFalse(seaArea.isWithinBounds(position));
    }

    @Test
    public void positionWithNegativeYCoordinateOutsideBoundsIsIdentified() {

        //Given
        List<Integer> position = Arrays.asList(0, -1);


        //Then
        Assert.assertFalse(seaArea.isWithinBounds(position));
    }

    @Test
    public void positionWithoutOilSpilIsIdentified(){

        //Given
        List<Integer> position = Arrays.asList(1, 0);


        //Then
        Assert.assertFalse(seaArea.isDirty(position));
    }

    @Test
    public void positionWithOilPatchIsIdentified() {

        //Given
        List<Integer> position = Arrays.asList(2, 3);


        //Then
        Assert.assertTrue(seaArea.isDirty(position));
    }

//    @Test
//    public void oilPatchIsRemoved() {
//
//        //Given
//        List<Integer> position = Arrays.asList(2, 3);
//
//        //When
//        seaArea.removeDirt(position);
//
//        //Then
//        Assert.assertTrue(seaArea.getOilPatches().isEmpty());
//    }

}
