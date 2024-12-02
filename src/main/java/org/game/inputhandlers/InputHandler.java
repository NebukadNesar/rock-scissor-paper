package org.game.inputhandlers;

import org.game.Duels;

/**
 * This class is responsible for getting the input values from different sources.
 * From buffered input reader, from files or any other sources with different implementations
 */
public interface InputHandler {
	/**
	 * Get the Selected number of games to play
	 *
	 * @return int
	 */
	int readNumberOfGame();

	/**
	 * Get Selected Duel for the current round
	 *
	 * @return String
	 */
	Duels readDuelOfRound();
}
