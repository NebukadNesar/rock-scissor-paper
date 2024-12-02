package org.game;

import java.util.Map;
import java.util.Set;

public class WinningCombination {

	private static final Map<Duels, Set<Duels>> winningCombinations = Map.of(
			Duels.Rock, Set.of(Duels.Scissor),
			Duels.Scissor, Set.of(Duels.Paper),
			Duels.Paper, Set.of(Duels.Rock));

	/**
	 * Checks if player1's duel beats player2's duel.
	 */
	public static int evaluateRound(Duels player1Duel, Duels player2Duel) {
		if (player1Duel == player2Duel) {
			return 0; // Tie
		}

		// Check if player1's duel beats player2's duel
		if (winningCombinations.get(player1Duel).contains(player2Duel)) {
			return 1; // Player 1 wins
		}

		return -1; // Player 2 wins
	}
}
