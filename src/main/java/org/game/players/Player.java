package org.game.players;

import org.game.Duels;

/**
 * Player is defined in two category, Computers and Humans
 * GameEngine requires two players.
 */
public interface Player {

	/**
	 * Select the number of games to be played
	 */
	int selectNumberOfGames();

	/**
	 * Select the duel for the current round
	 */
	Duels selectDuel();
}
