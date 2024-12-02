package org.game;

import org.game.inputhandlers.InputHandler;
import org.game.inputhandlers.InputHandlerFactory;
import org.game.players.Participant;
import org.game.players.Player;
import org.game.players.PlayerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestComputerPlayer {

	/**
	 * Validate computer player number of games selections are between the range or not.
	 */
	@Test
	public void test_ComputerPlayerGameSelection() {
		// checking if Computer can select correct number of games
		Player computer = PlayerFactory.creatComputerPlayer();
		for (int i = 0; i < 100; i++) {
			int computerNumberOfGamesSelection = computer.selectNumberOfGames();
			Assertions.assertTrue(computerNumberOfGamesSelection >= GameResources.MIN_GAME_COUNT
					&& computerNumberOfGamesSelection <= GameResources.MAX_GAME_COUNT,
					"Computer player cannot select valid number of games!");

		}
	}

	/**
	 * Validates computer player Duels selection
	 */
	@Test
	public void test_ComputerPlayerDuelSelection() {
		// checking if Computer can select a duel correctly with multiple attempts
		Player computer = PlayerFactory.creatComputerPlayer();
		for (int i = 0; i < 100; i++) {
			Duels computerDuelSelection = computer.selectDuel();
			Assertions.assertNotNull(computerDuelSelection, "Computer player cannot select valid duel!");
		}
	}
}
