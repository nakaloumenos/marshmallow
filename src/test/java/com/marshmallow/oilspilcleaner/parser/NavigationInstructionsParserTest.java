package com.marshmallow.oilspilcleaner.parser;

import com.marshmallow.oilspilcleaner.command.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NavigationInstructionsParserTest {

    @Test
    public void stringNMapsToMoveUpCommand() {
        //Given
        NavigationInstructionsParser parser = new NavigationInstructionsParser("N");

        //When
        List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
    }

    @Test
    public void stringSMapsToMoveDownCommand() {
        //Given
        NavigationInstructionsParser parser = new NavigationInstructionsParser("S");

        //When
        List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveDownCommand);
    }

    @Test
    public void stringWMapsToMoveLeftCommand() {
        //Given
        NavigationInstructionsParser parser = new NavigationInstructionsParser("W");

        //When
        List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveLeftCommand);
    }

    @Test
    public void stringEMapsToMoveRightCommand() {
        //Given
        NavigationInstructionsParser parser = new NavigationInstructionsParser("E");

        //When
        List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveRightCommand);
    }

    @Test
    public void emptyStringResultsInEmptyCommandList() {
        //Given
        NavigationInstructionsParser parser = new NavigationInstructionsParser("");

        //When
        List<Command> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }


    @Test
    public void nullStringResultsInEmptyCommandList() {
        //Given
        NavigationInstructionsParser parser = new NavigationInstructionsParser(null);

        //When
        List<Command> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void stringToCommandMappingIsCaseInsensitive() {
        //Given
        NavigationInstructionsParser parser = new NavigationInstructionsParser("nN");

        //When
        List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
        Assert.assertTrue(commands.get(1) instanceof MoveUpCommand);
    }

    @Test
    public void multiCommandStringIsMappedToCommandsInSameOrder() {
        //Given
        NavigationInstructionsParser parser = new NavigationInstructionsParser("NSWE");

        //When
        List<Command> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveUpCommand);
        Assert.assertTrue(commands.get(1) instanceof MoveDownCommand);
        Assert.assertTrue(commands.get(2) instanceof MoveLeftCommand);
        Assert.assertTrue(commands.get(3) instanceof MoveRightCommand);

    }

}
