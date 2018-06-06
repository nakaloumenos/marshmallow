package com.marshmallow.oilspilcleaner.command;

import com.marshmallow.oilspilcleaner.domain.RoboticCleaner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MoveLeftCommandTest {
    @Test
    public void testMoveLeftCommandMovesCleanerLeft() {
        //Given
        MoveLeftCommand command = new MoveLeftCommand();
        List<Integer> startingPosition = Arrays.asList(2, 4);
        RoboticCleaner roboticCleaner = new RoboticCleaner(startingPosition);

        //When
        List<Integer> newPosition = command.move(roboticCleaner);

        //Then
        Assert.assertEquals(1, (int) newPosition.get(0));
        Assert.assertEquals(4, (int) newPosition.get(1));
    }
}
