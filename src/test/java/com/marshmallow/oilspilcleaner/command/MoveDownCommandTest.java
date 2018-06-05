package com.marshmallow.oilspilcleaner.command;

import com.marshmallow.oilspilcleaner.domain.RoboticCleaner;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MoveDownCommandTest {

    @Test
    public void testMoveDownCommandMovesCleanerDown() {
        //Given
        MoveDownCommand command = new MoveDownCommand();
        List<Integer> startingPosition = Arrays.asList(1, 4);
        RoboticCleaner roboticCleaner = new RoboticCleaner(startingPosition);

        //When
        List<Integer> newPosition = command.move(roboticCleaner);

        //Then
        Assert.assertEquals(1 , (int) newPosition.get(0));
        Assert.assertEquals(3 , (int) newPosition.get(1));
    }

}
