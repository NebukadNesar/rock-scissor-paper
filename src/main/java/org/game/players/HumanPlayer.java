package org.game.players;

import org.game.Duels;
import org.game.inputhandlers.InputHandler;

/**
 * Human player is unlike Computer player is an input dependent player
 * <p>
 * Human player requires an input source to provide his/her selections
 */
public class HumanPlayer implements Player {
	private final InputHandler inputHandler;

	public HumanPlayer(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}

	@Override
	public int selectNumberOfGames() {
		return inputHandler.readNumberOfGame();
	}

	@Override
	public Duels selectDuel() {
		String duelOfRound = inputHandler.readDuelOfRound();
		if (duelOfRound == null) {
			return null;
		}
		return Duels.findDuelByName(duelOfRound.trim());
	}
}
