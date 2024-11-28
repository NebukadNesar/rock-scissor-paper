package org.game.inputhandlers;

import static org.game.GameResources.MAX_GAME_COUNT;
import static org.game.GameResources.MIN_GAME_COUNT;

import java.io.BufferedReader;

import static org.game.GameLogger.printNewLine;
import static org.game.GameLogger.printSameLine;

/**
 * By using the constructor injection of dependencies, the implementation classes become more testable
 * In case of below BufferedReader we can provide mock implementations of it and test the actual behaviour
 * of InputHandler
 */
public class GameConsoleInputHandler implements InputHandler {
	private final BufferedReader userInputReader;

	public GameConsoleInputHandler(BufferedReader userInputReader) {
		this.userInputReader = userInputReader;
	}

	@Override
	public int readNumberOfGame() {
		try {
			while (true) {
				printSameLine("Please enter the number of game you want to play:");
				String input = userInputReader.readLine();
				int numberOfGames = parseInputToNumber(input);
				if (numberOfGames < MIN_GAME_COUNT || numberOfGames > MAX_GAME_COUNT) {
					printNewLine(String.format("You did not enter a valid number of game (%d-%d)!", MIN_GAME_COUNT, MAX_GAME_COUNT));
				} else {
					printNewLine("Selected number of games is " + numberOfGames);
					return numberOfGames;
				}
			}
		} catch (Exception e) {
			printNewLine("Error reading game round." + e.getMessage());
			printNewLine("Default selected minimum number of games=" + MIN_GAME_COUNT);
			return MIN_GAME_COUNT;
		}
	}

	@Override
	public String readDuelOfRound() {
		try {
			String yourDuelSelection = userInputReader.readLine();
			return yourDuelSelection != null ? yourDuelSelection.toLowerCase().trim() : null;
		} catch (Exception e) {
			printNewLine("Error reading round input." + e.getMessage());
		}
		return null;
	}

	private static int parseInputToNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			return -1;
		}
	}
}