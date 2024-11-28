package org.game.players;

import org.game.Duels;

import java.util.Random;

import static org.game.GameResources.MAX_GAME_COUNT;

/**
 * Computer player is randomizing the duels selection and number of games selection.
 */
public class ComputerPlayer implements Player {
	private final Random random = new Random();

	@Override
	public int selectNumberOfGames() {
		return random.nextInt(MAX_GAME_COUNT) + 1;
	}

	@Override
	public Duels selectDuel() {
		return Duels.values()[random.nextInt(Duels.values().length)];
	}

}
