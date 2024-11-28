package org.game;

import org.game.players.HumanPlayer;
import org.game.players.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

import org.game.inputhandlers.GameConsoleInputHandler;
import org.game.inputhandlers.InputHandler;

public class TestHumanPlayer {

	/**
	 * validates the human player number of game selections
	 */
	@Test
	public void test_HumanPlayerGameSelection() {
		int numberOfGame = 1;
		BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
		InputHandler inputHandler = new GameConsoleInputHandler(userInputReader) {
			@Override
			public int readNumberOfGame() {
				return numberOfGame;
			}

			@Override
			public String readDuelOfRound() {
				return "incorrect duel choice";
			}
		};

		Player humanPlayer = new HumanPlayer(inputHandler);
		int humanSelectNumberOfGame = humanPlayer.selectNumberOfGames();
		Assertions.assertEquals(numberOfGame, humanSelectNumberOfGame, "Human player did not select number of game correctly!");
	}

	/**
	 * validate human player Duels selection for different type of inputs and compare them with the expected and actual results
	 */
	@Test
	public void test_HumanPlayerDuelSelection() {
		String[] humanPlayerDuelsSelections = { "Rock", "Paper", "Paper", null, "Scissor", "Random" };
		boolean[] expectedOutComeOfInputs = { true, true, true, false, true, false };

		int numberOfDuels = humanPlayerDuelsSelections.length;
		Player humanPlayer = getHumanPlayer(humanPlayerDuelsSelections);
		boolean[] actualOutComeOfInputs = new boolean[numberOfDuels];

		for (int i = 0; i < numberOfDuels; i++) {
			Duels humanPlayerDuelsSelection = humanPlayer.selectDuel();
			actualOutComeOfInputs[i] = humanPlayerDuelsSelection != null;
		}

		Assertions.assertArrayEquals(expectedOutComeOfInputs, actualOutComeOfInputs, "Human player selection is not evaluated correctly!");
	}

	private static Player getHumanPlayer(String[] humanPLayerDuelsSelections) {
		AtomicInteger playerInputIndex = new AtomicInteger(0);
		BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
		InputHandler inputHandler = new GameConsoleInputHandler(userInputReader) {
			@Override
			public int readNumberOfGame() {
				return humanPLayerDuelsSelections.length;
			}

			@Override
			public String readDuelOfRound() {
				String selection = humanPLayerDuelsSelections[playerInputIndex.getAndIncrement()];
				return selection == null ? null : selection.toLowerCase();
			}
		};

		return new HumanPlayer(inputHandler);
	}
}
