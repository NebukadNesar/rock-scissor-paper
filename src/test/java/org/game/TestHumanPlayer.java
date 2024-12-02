package org.game;

import org.game.inputhandlers.InputHandlerFactory;
import org.game.players.Participant;
import org.game.players.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

import org.game.inputhandlers.InterActiveInputHandler;
import org.game.inputhandlers.InputHandler;

public class TestHumanPlayer {

	/**
	 * validates the human player number of game selections
	 */
	@Test
	public void test_HumanPlayerGameSelection() {
		int numberOfGame = 1;
		BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
		InputHandler inputHandler = new InterActiveInputHandler(userInputReader) {
			@Override
			public int readNumberOfGame() {
				return numberOfGame;
			}

			@Override
			public Duels readDuelOfRound() {
				return null;
			}
		};

		Player humanPlayer = new Participant(inputHandler);
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
		InputHandler inputHandler = new InterActiveInputHandler(userInputReader) {
			@Override
			public int readNumberOfGame() {
				return humanPLayerDuelsSelections.length;
			}

			@Override
			public Duels readDuelOfRound() {
				String selection = humanPLayerDuelsSelections[playerInputIndex.getAndIncrement()];
				try {
					return Duels.valueOf(selection);
				} catch (Exception e) {
					return null;
				}
			}
		};

		return new Participant(inputHandler);
	}
}
