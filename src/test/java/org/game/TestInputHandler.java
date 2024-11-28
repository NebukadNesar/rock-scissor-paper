package org.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

import org.game.inputhandlers.GameConsoleInputHandler;
import org.game.inputhandlers.InputHandler;

public class TestInputHandler {

	/**
	 * Input handler (GameConsoleInputHandler) will request user to enter correct input or input in range of game configurations
	 * in this test case the all input are incorrect and cannot be parsed to a valid number, until the last input "5"
	 */
	@Test
	public void test_InputHandlerReadNumberOfGame() {
		int validInputForNumberOfGames = 5;
		String[] userInputs = { "-1", "t e s t", "ROCK", "SCISSOR", "PAper", "0", String.valueOf(validInputForNumberOfGames) };
		AtomicInteger inputIndex = new AtomicInteger(0);

		BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in)) {
			@Override
			public String readLine() {
				return userInputs[inputIndex.getAndIncrement()];
			}
		};
		InputHandler inputHandler = new GameConsoleInputHandler(userInputReader);
		int selectedNumberOfGames = inputHandler.readNumberOfGame();

		Assertions.assertEquals(validInputForNumberOfGames, selectedNumberOfGames, "Console input reader cannot handle user inputs correctly!");
	}

	/**
	 * Test input handler (GameConsoleInputHandler) validate reading of Duels for round for different inputs
	 * Test expected outcome of input vs the actual outcome of inputs populated by each input evaluation
	 */
	@Test
	public void test_InputHandlerReadDuelOfRound() {
		String[] userInputs = { "", "t e s t", "ROCK", "SCISSOR", "PAper", "0", null };
		boolean[] expectedOutcomeOfInputs = { false, false, true, true, true, false, false };

		AtomicInteger inputIndex = new AtomicInteger(0);
		BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in)) {
			@Override
			public String readLine() {
				return userInputs[inputIndex.getAndIncrement()];
			}
		};

		InputHandler inputHandler = new GameConsoleInputHandler(userInputReader);
		int numberOfInputs4test = userInputs.length;
		boolean[] actualOutcomeOfInputs = new boolean[numberOfInputs4test];

		for (int i = 0; i < numberOfInputs4test; i++) {
			String duelOfRound = inputHandler.readDuelOfRound();
			Duels duelForRound = Duels.findDuelByName(duelOfRound);
			actualOutcomeOfInputs[i] = duelForRound != null;
		}

		Assertions.assertArrayEquals(expectedOutcomeOfInputs, actualOutcomeOfInputs, "Console input reader cannot handle user inputs correctly!");
	}
}
