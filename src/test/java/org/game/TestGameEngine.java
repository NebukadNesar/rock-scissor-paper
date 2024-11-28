package org.game;

import static org.game.GameResources.PLAYER1;

import org.game.players.ComputerPlayer;
import org.game.players.HumanPlayer;
import org.game.players.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

import org.game.inputhandlers.GameConsoleInputHandler;
import org.game.inputhandlers.InputHandler;

/**
 * Test Computer vs Human
 */
public class TestGameEngine {
	private static final int numberOfGames = 5;
	private static final Duels[] userDuels = { Duels.Rock, Duels.Scissor, Duels.Paper, Duels.Rock, Duels.Rock };
	private static final Duels[] computerDuels = { Duels.Scissor, Duels.Scissor, Duels.Rock, Duels.Paper, Duels.Scissor };
	private static final AtomicInteger humanDuelSelectCounter = new AtomicInteger(0);
	private static final AtomicInteger computerDuelSelectCounter = new AtomicInteger(0);
	private static final String expectedWinner = PLAYER1;

	/**
	 * Tests and Validate the GameEngine work flow with one Human player and one Computer player.
	 * The winner is determined by comparing the expected results vs the actual result by evaluating the provided inputs
	 */
	@Test
	public void test_GameEngine() {
		BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
		InputHandler inputHandler = new GameConsoleInputHandler(userInputReader);
		Player humanPlayer = new HumanPlayer(inputHandler) {
			@Override
			public int selectNumberOfGames() {
				return numberOfGames;
			}

			@Override
			public Duels selectDuel() {
				return youSelectNextDuel();
			}
		};

		Player computerPlayer = new ComputerPlayer() {
			@Override
			public int selectNumberOfGames() {
				return numberOfGames;
			}

			@Override
			public Duels selectDuel() {
				return computerSelectNextDuel();
			}
		};

		GameEngine gameEngine = new GameEngine(humanPlayer, computerPlayer);
		String actualWinner = gameEngine.playGame();
		Assertions.assertEquals(expectedWinner, actualWinner, "Winner is not correctly evaluated!");
	}

	private Duels youSelectNextDuel() {
		return userDuels[humanDuelSelectCounter.getAndIncrement()];
	}

	private Duels computerSelectNextDuel() {
		return computerDuels[computerDuelSelectCounter.getAndIncrement()];
	}
}
