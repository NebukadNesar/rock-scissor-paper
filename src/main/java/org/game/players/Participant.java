package org.game.players;

import org.game.Duels;
import org.game.inputhandlers.InputHandler;

public class Participant implements Player {

	private final InputHandler inputHandler;

	public Participant(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}

	@Override
	public int selectNumberOfGames() {
		return inputHandler.readNumberOfGame();
	}

	@Override
	public Duels selectDuel() {
		return inputHandler.readDuelOfRound();
	}
}