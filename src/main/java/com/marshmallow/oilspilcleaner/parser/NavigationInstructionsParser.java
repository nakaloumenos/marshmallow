package com.marshmallow.oilspilcleaner.parser;

import com.marshmallow.oilspilcleaner.command.*;

import java.util.*;

public class NavigationInstructionsParser {

    private String navigationInstructions;

    private static Map<String, Command> navigationCharacterToCommand = new HashMap<String, Command>() {{
        put("N", new MoveUpCommand());
        put("S", new MoveDownCommand());
        put("W", new MoveLeftCommand());
        put("E", new MoveRightCommand());
    }};

    public NavigationInstructionsParser(String navigationInstructions) {
        this.navigationInstructions = navigationInstructions;
    }

    public List<Command> toCommands() {
        if(isNullOrEmpty(navigationInstructions)) return new ArrayList<>();
        return buildCommandsList(navigationInstructions);
    }

    private boolean isNullOrEmpty(String navigationInstructions) {
        return (navigationInstructions == null || navigationInstructions.length() == 0);
    }

    private List<Command> buildCommandsList(final String navigationInstructions) {
        List<Command> commands = new ArrayList<>();

        for(String commandCharacter : commandCharactersFrom(navigationInstructions)) {
            if (commandCharacter == null) break;
            Command mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
            commands.add(mappedCommand);
        }

        return commands;
    }

    private String[] commandCharactersFrom(final String commandString) {
        return Arrays.copyOfRange(commandString.split(""), 0, commandString.length() + 1);
    }

    private Command lookupEquivalentCommand(final String commandString) {
        return navigationCharacterToCommand.get(commandString);
    }

}
