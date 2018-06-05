package com.marshmallow.oilspilcleaner.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RoboticCleanerTest {

    private RoboticCleaner roboticCleaner;

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



}
