package org.game;

import org.game.players.Player;

import java.util.Map;
import java.util.Set;

import static org.game.GameResources.PLAYER2;
import static org.game.GameResources.NO_WINNER;
import static org.game.GameResources.PLAYER1;
import static org.game.GameLogger.printNewLine;
import static org.game.GameLogger.printSameLine;

/**
 * The GameEngine class is responsible for handling the game logic. It performs the following tasks:
 * <ul>
 * <li>Evaluates the players' inputs.</li>
 * <li>Declares the winner of each Round.</li>
 * <li>Declares the overall winner of the Game.</li>
 * </ul>
 * The GameEngine is designed to be independent of any specific dependencies, allowing it to support
 * various types of player interactions such as:
 * <ul>
 * <li>Computer vs. Computer</li>
 * <li>Human vs. Human</li>
 * <li>Human vs. Computer</li>
 * </ul>
 */
public class GameEngine {
	private final Player player1;
	private final Player player2;

	public GameEngine(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String playGame() {
		int gameCount = player1.selectNumberOfGames();
		int result = play(gameCount);
		String winner = declareWinner(result);
		printNewLine("Game over! The winner is: " + winner);
		return winner;
	}

	private int play(int gameCount) {
		int result = 0;
		printNewLine("Game started! Please select your duel(Rock, Scissor, Paper)");
		int playedRounds = 1;
		while (playedRounds <= gameCount) {
			printSameLine("Player1 selection:");
			Duels player1Selection = player1.selectDuel();
			Duels player2Selection = player2.selectDuel();
			printNewLine("Player2 selection:" + (player2Selection != null ? player2Selection.getName() : "No Duel!"));

			if (player1Selection == null || player2Selection == null) {
				printNewLine("Players didn't select a Duel!");
				continue;
			}

			int roundResult = WinningCombination.evaluateRound(player1Selection, player2Selection);
			result += roundResult;

			printNewLine(String.format("Round (%d of %d) winner is = %s", playedRounds, gameCount, declareWinner(roundResult)));
			playedRounds++;
		}
		return result;
	}

	private String declareWinner(int roundResult) {
		if (roundResult > 0) {
			return PLAYER1;
		} else if (roundResult < 0) {
			return PLAYER2;
		}
		return NO_WINNER;
	}

}