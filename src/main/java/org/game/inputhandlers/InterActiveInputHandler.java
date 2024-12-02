package org.game.inputhandlers;

import org.game.Duels;

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
public class InterActiveInputHandler implements InputHandler {
	private final BufferedReader userInputReader;

	public InterActiveInputHandler(BufferedReader userInputReader) {
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
	public Duels readDuelOfRound() {
		try {
			String yourDuelSelection = userInputReader.readLine();
			yourDuelSelection = yourDuelSelection != null ? yourDuelSelection.toLowerCase().trim() : null;
			if (yourDuelSelection == null) {
				return null;
			}
			return Duels.findDuelByName(yourDuelSelection);
		} catch (Exception e) {
			printNewLine("Error reading round input." + e.getMessage());
		}

		throw new IllegalArgumentException("invalid duel selection!");
	}

	private static int parseInputToNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			return -1;
		}
	}
}
